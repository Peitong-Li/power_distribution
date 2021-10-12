package com.yjw.power_distribution.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yjw.power_distribution.pojo.*;
import com.yjw.power_distribution.service.BaseInfoService;
import com.yjw.power_distribution.service.DealService;
import com.yjw.power_distribution.service.DeviceService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class CourtsController {

    @Autowired
    DeviceService deviceService;

    @Autowired
    BaseInfoService baseInfoService;

    @Autowired
    DealService dealService;
    //上传台区图片及设备信息
    @PostMapping("/uploadInfoByhand")
    @ResponseBody
    public ResponseObj uploadPicture(@RequestParam(required=true) MultipartFile imageFile,
                                @RequestParam(value = "infoType", required=true) Integer infoType,
                                @RequestParam(value = "dataFile", required=false) MultipartFile dataFile,
                                @RequestParam(required=false)  String courtsName,
                                @RequestParam(required=false) String Transformers,
                                @RequestParam(required=false) String EvSensors,
                                @RequestParam(required=false) String AreaMeters,
                                @RequestParam(required=false) String Terminals,
                                @RequestParam(required=false) String Fuses,
                                @RequestParam(required=false) String IntelligentSwitchs,
                                @RequestParam(required=false) String UniphaseMeters,
                                @RequestParam(required=false) String LTUSwitchs,
                                @RequestParam(required=false) String ChangePhaseSwitchs,
                                @RequestParam(required=false) String ChargingFacilitys,
                                @RequestParam(required=false) String PvUsers,
                                @RequestParam(required=false) String CompensationDevices,
                                @RequestParam(required=false) String CableSensingDevices,
                                @RequestParam(required=false) String ThreePhaseMeters)throws Exception{
        ResponseObj responseObj = new ResponseObj();
        System.out.println("获取的台区名称："+courtsName);
        System.out.println("typeInfo："+infoType);


        if(!imageFile.isEmpty()) {   //imageFile不为空
            String imageFileName = imageFile.getOriginalFilename();     //获取图片名
            String image_suffixName = imageFileName.substring(imageFileName.lastIndexOf("."));//图片后缀
            String new_imageFileName = UUID.randomUUID()+image_suffixName;   //UUID生成前缀

            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            System.out.print("静态资源路径："+path);
            String imagePath = path+ "static/courtsImages/"+new_imageFileName;  //上传图片路径

            File image_dest = new File(imagePath);
            if(!image_dest.getParentFile().exists()){
                image_dest.getParentFile().mkdirs();  //不存在路径  创建路径
            }

            // Select Save Info mode
            if(infoType == 0){   // UploadInfo By Hand
//                if(!dataFile.isEmpty()){  //dataFile not null
//                    Integer process_res = process_excel_file(dataFile);
//                    if (process_res == 0){
//                        responseObj.setStateCode(0);
//                        responseObj.setInfo("Upload failed! Network error.");
//                        return responseObj;
//                    } else {
//                        responseObj.setStateCode(1);
//                        responseObj.setInfo("Upload Successful！");
//                        return responseObj;
//                    }
//                }
            }
            else {  // UploadInfo By Excel
                //判断台区名是否重复
                int IsCourtsNameRepeat = deviceService.searchCountOfCourtsByName(courtsName);
                if(IsCourtsNameRepeat >= 1){
                    responseObj.setStateCode(0);
                    responseObj.setInfo("台区名重复！");
                    return responseObj;
                }
                try{
                    //图片转移到指定路径
                    imageFile.transferTo(image_dest);
                    //上传台区
                    Courts courts = new Courts();
                    courts.setCourtsName(courtsName);
                    courts.setCourtsImageUrl(new_imageFileName);
                    int uploadResult = deviceService.uploadCourts(courts);
                    if(uploadResult>=1){
                        //上传成功返回台区Id
                        int courtsId = deviceService.findCourtsIdByName(courtsName);
                        //上传设备
                        //  Transformers, EvSensors, AreaMeters, Terminals, Fuses, IntelligentSwitchs, UniphaseMeters,
                        //  LTUSwitchs, ChangePhaseSwitchs, ChargingFacilitys, PvUsers, CompensationDevices, CableSensingDevices, ThreePhaseMeters
                        int flag = 0;
                        //1、将json字符串转成json数组
                        JSONArray jsonArray_1 = JSONArray.parseArray(Transformers);
                        for(int i=0;i<jsonArray_1.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_1.getJSONObject(i);
                            //将json对象转换成实体类对象
                            Transformer transformer = JSON.parseObject(obj.toString(),Transformer.class);
                            transformer.setCourtsId(courtsId);
                            int result = deviceService.addTransformer(transformer);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_2 = JSONArray.parseArray(EvSensors);
                        for(int i=0;i<jsonArray_2.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_2.getJSONObject(i);
                            //将json对象转换成实体类对象
                            EvSensor evSensor = JSON.parseObject(obj.toString(),EvSensor.class);
                            evSensor.setCourtsId(courtsId);
                            int result = deviceService.addEvSensor(evSensor);
                            if(result>=1){
                                flag++;
                            }
                        }

                        JSONArray jsonArray_3 = JSONArray.parseArray(AreaMeters);
                        for(int i=0;i<jsonArray_3.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_3.getJSONObject(i);
                            //将json对象转换成实体类对象
                            AreaMeter areaMeter = JSON.parseObject(obj.toString(),AreaMeter.class);
                            areaMeter.setCourtsId(courtsId);
                            int result = deviceService.addAreaMeter(areaMeter);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_4 = JSONArray.parseArray(Fuses);
                        for(int i=0;i<jsonArray_4.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_4.getJSONObject(i);
                            //将json对象转换成实体类对象
                            Fuse fuse = JSON.parseObject(obj.toString(),Fuse.class);
                            fuse.setCourtsId(courtsId);
                            int result = deviceService.addFuse(fuse);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_5 = JSONArray.parseArray(IntelligentSwitchs);
                        for(int i=0;i<jsonArray_5.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_5.getJSONObject(i);
                            //将json对象转换成实体类对象
                            IntelligentSwitch intelligentSwitch = JSON.parseObject(obj.toString(),IntelligentSwitch.class);
                            intelligentSwitch.setCourtsId(courtsId);
                            int result = deviceService.addIntelligentSwitch(intelligentSwitch);
                            if(result>=1){
                                flag++;
                            }
                        }

                        JSONArray jsonArray_6 = JSONArray.parseArray(UniphaseMeters);
                        for(int i=0;i<jsonArray_6.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_6.getJSONObject(i);
                            //将json对象转换成实体类对象
                            UniphaseMeter uniphaseMeter = JSON.parseObject(obj.toString(),UniphaseMeter.class);
                            uniphaseMeter.setCourtsId(courtsId);
                            int result = deviceService.addUniphaseMeter(uniphaseMeter);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_7 = JSONArray.parseArray(LTUSwitchs);
                        for(int i=0;i<jsonArray_7.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_7.getJSONObject(i);
                            //将json对象转换成实体类对象
                            LTUSwitch ltuSwitch = JSON.parseObject(obj.toString(),LTUSwitch.class);
                            ltuSwitch.setCourtsId(courtsId);
                            int result = deviceService.addLTUSwitch(ltuSwitch);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_8 = JSONArray.parseArray(ChangePhaseSwitchs);
                        for(int i=0;i<jsonArray_8.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_8.getJSONObject(i);
                            //将json对象转换成实体类对象
                            ChangePhaseSwitch changePhaseSwitch = JSON.parseObject(obj.toString(),ChangePhaseSwitch.class);
                            changePhaseSwitch.setCourtsId(courtsId);
                            int result = deviceService.addChangePhaseSwitch(changePhaseSwitch);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_9 = JSONArray.parseArray(ChargingFacilitys);
                        for(int i=0;i<jsonArray_9.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_9.getJSONObject(i);
                            //将json对象转换成实体类对象
                            ChargingFacility chargingFacility = JSON.parseObject(obj.toString(),ChargingFacility.class);
                            chargingFacility.setCourtsId(courtsId);
                            int result = deviceService.addChargingFacility(chargingFacility);
                            if(result>=1){
                                flag++;
                            }
                        }

                        JSONArray jsonArray_10 = JSONArray.parseArray(PvUsers);
                        for(int i=0;i<jsonArray_10.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_10.getJSONObject(i);
                            //将json对象转换成实体类对象
                            PvUser pvUser = JSON.parseObject(obj.toString(),PvUser.class);
                            pvUser.setCourtsId(courtsId);
                            int result = deviceService.addPvUser(pvUser);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_11 = JSONArray.parseArray(CompensationDevices);
                        for(int i=0;i<jsonArray_11.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_11.getJSONObject(i);
                            //将json对象转换成实体类对象
                            CompensationDevice compensationDevice = JSON.parseObject(obj.toString(),CompensationDevice.class);
                            compensationDevice.setCourtsId(courtsId);
                            int result = deviceService.addCompensationDevice(compensationDevice);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_12 = JSONArray.parseArray(CableSensingDevices);
                        for(int i=0;i<jsonArray_12.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_12.getJSONObject(i);
                            //将json对象转换成实体类对象
                            CableSensingDevice cableSensingDevice = JSON.parseObject(obj.toString(),CableSensingDevice.class);
                            cableSensingDevice.setCourtsId(courtsId);
                            int result = deviceService.addCableSensingDevice(cableSensingDevice);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_13 = JSONArray.parseArray(ThreePhaseMeters);
                        for(int i=0;i<jsonArray_13.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_13.getJSONObject(i);
                            //将json对象转换成实体类对象
                            ThreePhaseMeter threePhaseMeter = JSON.parseObject(obj.toString(),ThreePhaseMeter.class);
                            threePhaseMeter.setCourtsId(courtsId);
                            int result = deviceService.addThreePhaseMeter(threePhaseMeter);
                            if(result>=1){
                                flag++;
                            }
                        }
                        JSONArray jsonArray_14 = JSONArray.parseArray(Terminals);
                        for(int i=0;i<jsonArray_14.size();i++){
                            //取出每个json对象
                            JSONObject obj = jsonArray_14.getJSONObject(i);
                            //将json对象转换成实体类对象
                            Terminal terminal = JSON.parseObject(obj.toString(),Terminal.class);
                            terminal.setCourtsId(courtsId);
                            int result = deviceService.addTerminal(terminal);
                            if(result>=1){
                                flag++;
                            }
                        }
                    }
                }catch (Exception exception){
                    exception.printStackTrace();
                    responseObj.setStateCode(0);
                    responseObj.setInfo("上传失败！");
                    return responseObj;
                }
            }
        }
        else {
            responseObj.setStateCode(0);
            responseObj.setInfo("Image Upload Fail!");
        }
        responseObj.setStateCode(1);
        responseObj.setInfo("Upload Info Successful");
        return responseObj;
    }

    private Integer process_excel_file(MultipartFile datafile) throws IOException {
        File toFile = null;
        if (datafile.equals("") || datafile.getSize() <= 0 || datafile.isEmpty()) {
            return 0;
        } else {
            InputStream ins = null;
            ins = datafile.getInputStream();
            toFile = new File(datafile.getOriginalFilename());
            String resString = inputStreamToFile(ins, toFile);
            ins.close();
            if(resString != null){
                return 0;
            }
        }
        try{
            FileInputStream in = null;
            in = new FileInputStream(toFile); 					// 创建对Excel工作簿文件的引用
            Workbook book = new XSSFWorkbook(in);
            for (int t = 0; t < book.getNumberOfSheets(); t++){
                Sheet sheet = book.getSheetAt(t);
                Row row = null;
                int lastRowNum = sheet.getLastRowNum();

                for (int i = 0; i <= lastRowNum; i++){
                    row = sheet.getRow(i);
                    if (row != null){
                        for (int j = 0; j < row.getLastCellNum(); j++){
                            Cell cell = row.getCell(j);
                            String value = getCellValue(cell);
                            if (!value.equals("")){
                                System.out.print(value + "\t");
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    //获取流文件
    private static String inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return "InputStreamToFile failed!";
        }
    }

    private static String getCellValue(Cell cell) {
        String resultValue = "";
        // 判空
        if (Objects.isNull(cell)) {
            return resultValue;
        }

        // 拿到单元格类型
        int cellType = cell.getCellType();
        switch (cellType) {
            // 字符串类型
            case Cell.CELL_TYPE_STRING:
                resultValue = StringUtils.isEmpty(cell.getStringCellValue()) ? "" : cell.getStringCellValue().trim();
                break;
            // 布尔类型
            case Cell.CELL_TYPE_BOOLEAN:
                resultValue = String.valueOf(cell.getBooleanCellValue());
                break;
            // 数值类型
            case Cell.CELL_TYPE_NUMERIC:
                resultValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
                break;
            // 取空串
            default:
                break;
        }
        return resultValue;
    }

    //查询所有台区
    @PostMapping(value="/findAllCourts",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String findAllCourts() throws Exception{
        List<Courts> courtsList = deviceService.findAllCourts();
        System.out.println("查询所有台区成功");
        return JSON.toJSONString(courtsList);
    }


    //通过台区id查找该台去所有设备
    @PostMapping(value="/findAllDeviceByCourtsId",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object findAllDeviceByCourtsId(int courtsId) throws Exception{

        System.out.println("获取到的台区Id："+courtsId);

        //返回的对象
        CourtsDevice courtsDevice = new CourtsDevice();

        //根据Id查询台区
        Courts courts = deviceService.findCourtsByCourtsId(courtsId);
        courtsDevice.setCourts(courts);


        List<Transformer> transformerList = deviceService.findTransformer(courtsId);
        courtsDevice.setTransformerList(transformerList);
        System.out.println("查询Transformer成功");

        List<EvSensor> evSensorList = deviceService.findEvSensor(courtsId);
        courtsDevice.setEvSensorList(evSensorList);
        System.out.println("查询EvSensor成功");

        List<AreaMeter> areaMeterList = deviceService.findAreaMeter(courtsId);
        courtsDevice.setAreaMeterList(areaMeterList);
        System.out.println("查询AreaMeter11111 成功");

        List<Fuse> fuseList = deviceService.findFuse(courtsId);
        courtsDevice.setFuseList(fuseList);
        System.out.println("查询Fuse成功");

        List<IntelligentSwitch> intelligentSwitchList = deviceService.findIntelligentSwitch(courtsId);
        courtsDevice.setIntelligentSwitchList(intelligentSwitchList);
        System.out.println("查询IntelligentSwitch成功");

        List<UniphaseMeter> uniphaseMeterList = deviceService.findUniphaseMeter(courtsId);
        courtsDevice.setUniphaseMeterList(uniphaseMeterList);
        System.out.println("查询UniphaseMeter成功");

        List<LTUSwitch> ltuSwitchList = deviceService.findLTUSwitch(courtsId);
        courtsDevice.setLtuSwitchList(ltuSwitchList);
        System.out.println("查询ltuSwitchList成功");

        List<ChangePhaseSwitch> changePhaseSwitchList = deviceService.findChangePhaseSwitch(courtsId);
        courtsDevice.setChangePhaseSwitchList(changePhaseSwitchList);
        System.out.println("查询changePhaseSwitchList成功");

        List<ChargingFacility> chargingFacilityList = deviceService.findChargingFacility(courtsId);
        courtsDevice.setChargingFacilityList(chargingFacilityList);
        System.out.println("查询chargingFacilityList成功");

        List<PvUser> pvUserList = deviceService.findPvUser(courtsId);
        courtsDevice.setPvUserList(pvUserList);
        System.out.println("查询PvUser成功");

        List<CompensationDevice> compensationDeviceList = deviceService.findCompensationDevice(courtsId);
        courtsDevice.setCompensationDeviceList(compensationDeviceList);
        System.out.println("查询CompensationDevice成功");

        List<CableSensingDevice> CableSensingDevice = deviceService.findCableSensingDevice(courtsId);
        courtsDevice.setCableSensingDeviceList(CableSensingDevice);
        System.out.println("查询CableSensingDevice成功");

        List<ThreePhaseMeter> threePhaseMeterList = deviceService.findThreePhaseMeter(courtsId);
        courtsDevice.setThreePhaseMeterList(threePhaseMeterList);
        System.out.println("查询ThreePhaseMeter成功");

        List<Terminal> terminalList = deviceService.findTerminal(courtsId);
        courtsDevice.setTerminalList(terminalList);
        System.out.println("查询Terminal成功");


        return courtsDevice;

    }


    //修改设备参数
    @PostMapping("/updateDevice")
    @ResponseBody
    public String updateDevice(int deviceId,String Transformer,String EvSensor,String AreaMeter,String Terminal,String Fuse,
                               String IntelligentSwitch,String UniphaseMeter, String LTUSwitch,String ChangePhaseSwitch,String ChargingFacility,
                               String PvUser,String CompensationDevice,String CableSensingDevice,String ThreePhaseMeter)throws Exception{
        System.out.println("Id:"+deviceId);
        System.out.println("Transformer:"+Transformer);
        System.out.println("EvSensor:"+EvSensor);
        System.out.println("AreaMeter:"+AreaMeter);
        System.out.println("Terminal:"+Terminal);
        System.out.println("Fuse:"+Fuse);
        System.out.println("IntelligentSwitch:"+IntelligentSwitch);
        System.out.println("UniphaseMeter:"+UniphaseMeter);
        System.out.println("LTUSwitch:"+LTUSwitch);
        System.out.println("ChangePhaseSwitch:"+ChangePhaseSwitch);
        System.out.println("ChargingFacility:"+ChargingFacility);
        System.out.println("PvUser:"+PvUser);
        System.out.println("CompensationDevice:"+CompensationDevice);
        System.out.println("CableSensingDevice:"+CableSensingDevice);
        System.out.println("ThreePhaseMeter:"+ThreePhaseMeter);
        //1
        if(Transformer!=null){//不为空更新数据库
            Transformer transformer = JSON.parseObject(Transformer,Transformer.class);
            transformer.setId(deviceId);
            int updateResult = deviceService.updateTransformer(transformer);
            if(updateResult==1){
                System.out.println("更新Transformer成功！");
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //2
        if(EvSensor!=null){//不为空更新数据库
            EvSensor evSensor = JSON.parseObject(EvSensor,EvSensor.class);
            evSensor.setId(deviceId);
            int updateResult = deviceService.updateEvSensor(evSensor);
            if(updateResult==1){
                System.out.println("更新evSensor成功！");
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //3
        if(AreaMeter!=null){//不为空更新数据库
            AreaMeter areaMeter = JSON.parseObject(AreaMeter,AreaMeter.class);
            areaMeter.setId(deviceId);
            int updateResult = deviceService.updateAreaMeter(areaMeter);
            if(updateResult==1){
                System.out.println("更新areaMeter成功！");
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //4
        if(Fuse!=null){//不为空更新数据库
            Fuse fuse = JSON.parseObject(Fuse,Fuse.class);
            fuse.setId(deviceId);
            int updateResult = deviceService.updateFuse(fuse);
            if(updateResult==1){
                System.out.println("更新Fuse成功！");
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //5
        if(IntelligentSwitch!=null){//不为空更新数据库
            IntelligentSwitch intelligentSwitch = JSON.parseObject(IntelligentSwitch,IntelligentSwitch.class);
            intelligentSwitch.setId(deviceId);
            int updateResult = deviceService.updateIntelligentSwitch(intelligentSwitch);
            if(updateResult==1){
                System.out.println("更新intelligentSwitch成功！");
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //6
        if(UniphaseMeter!=null){//不为空更新数据库
            UniphaseMeter uniphaseMeter = JSON.parseObject(UniphaseMeter,UniphaseMeter.class);
            uniphaseMeter.setId(deviceId);
            int updateResult = deviceService.updateUniphaseMeter(uniphaseMeter);
            if(updateResult==1){
                System.out.println("更新uniphaseMeter成功！");
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //7
        if(LTUSwitch!=null){//不为空更新数据库
            LTUSwitch ltuSwitch = JSON.parseObject(LTUSwitch,LTUSwitch.class);
            ltuSwitch.setId(deviceId);
            int updateResult = deviceService.updateLTUSwitch(ltuSwitch);
            if(updateResult>=1){
                System.out.println("更新ltuSwitch成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //8
        if(ChangePhaseSwitch!=null){//不为空更新数据库
            ChangePhaseSwitch changePhaseSwitch = JSON.parseObject(ChangePhaseSwitch,ChangePhaseSwitch.class);
            changePhaseSwitch.setId(deviceId);
            int updateResult = deviceService.updateChangePhaseSwitch(changePhaseSwitch);
            if(updateResult>=1){
                System.out.println("更新changePhaseSwitch成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //9
        if(ChargingFacility!=null){//不为空更新数据库
            ChargingFacility chargingFacility = JSON.parseObject(ChargingFacility,ChargingFacility.class);
            chargingFacility.setId(deviceId);
            int updateResult = deviceService.updateChargingFacility(chargingFacility);
            if(updateResult>=1){
                System.out.println("更新chargingFacilityr成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //10
        if(PvUser!=null){//不为空更新数据库
            PvUser pvUser = JSON.parseObject(PvUser,PvUser.class);
            pvUser.setId(deviceId);
            int updateResult = deviceService.updatePvUser(pvUser);
            if(updateResult>=1){
                System.out.println("更新pvUser成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //11
        if(CompensationDevice!=null){//不为空更新数据库
            CompensationDevice compensationDevice = JSON.parseObject(CompensationDevice,CompensationDevice.class);
            compensationDevice.setId(deviceId);
            int updateResult = deviceService.updateCompensationDevice(compensationDevice);
            if(updateResult>=1){
                System.out.println("更新compensationDevice成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //12
        if(CableSensingDevice!=null){//不为空更新数据库
            CableSensingDevice cableSensingDevice = JSON.parseObject(CableSensingDevice,CableSensingDevice.class);
            cableSensingDevice.setId(deviceId);
            int updateResult = deviceService.updateCableSensingDevice(cableSensingDevice);
            if(updateResult>=1){
                System.out.println("更新cableSensingDevice成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //13
        if(ThreePhaseMeter!=null){//不为空更新数据库
            ThreePhaseMeter threePhaseMeter = JSON.parseObject(ThreePhaseMeter,ThreePhaseMeter.class);
            threePhaseMeter.setId(deviceId);
            int updateResult = deviceService.updateThreePhaseMeter(threePhaseMeter);
            if(updateResult>=1){
                System.out.println("更新threePhaseMeter成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }
        //14
        if(Terminal!=null){//不为空更新数据库
            Terminal terminal = JSON.parseObject(Terminal,Terminal.class);
            terminal.setId(deviceId);
            int updateResult = deviceService.updateTerminal(terminal);
            if(updateResult>=1){
                System.out.println("更新terminal成功！"+updateResult);
                return "{\"updateMsg\":\"1\"}";
            }
        }

        return "0";
    }

    //删除设备
    @PostMapping("/delDevice")
    @ResponseBody
    public String delDevice(int deviceId,String deviceName)throws Exception{
        System.out.println("获取到需要删除的设备及Id:"+deviceName+"-"+deviceId);
        if(deviceName.equals("Transformer")){
            int result = deviceService.delTransformer(deviceId);
            if(result==1){
                System.out.println("删除Transformer成功！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("EvSensor")){
            int result = deviceService.delEvSensor(deviceId);
            if(result==1){
                System.out.println("删除EvSensor成功！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("AreaMeter")){
            int result = deviceService.delAreaMeter(deviceId);
            if(result==1){
                System.out.println("删除AreaMeter成功！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("Fuse")){
            int result = deviceService.delFuse(deviceId);
            if(result==1){
                System.out.println("删除Fuse成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("IntelligentSwitch")){
            int result = deviceService.delIntelligentSwitch(deviceId);
            if(result==1){
                System.out.println("删除IntelligentSwitch成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("UniphaseMeter")){
            int result = deviceService.delUniphaseMeter(deviceId);
            if(result==1){
                System.out.println("删除UniphaseMeter成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("LTUSwitch")){
            int result = deviceService.delLTUSwitch(deviceId);
            if(result==1){
                System.out.println("删除LTUSwitch成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("ChangePhaseSwitch")){
            int result = deviceService.delChangePhaseSwitch(deviceId);
            if(result==1){
                System.out.println("删除ChangePhaseSwitch成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("ChargingFacility")){
            int result = deviceService.delChargingFacility(deviceId);
            if(result==1){
                System.out.println("删除ChargingFacility成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("PvUser")){
            int result = deviceService.delPvUser(deviceId);
            if(result==1){
                System.out.println("删除PvUser成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("CompensationDevice")){
            int result = deviceService.delCompensationDevice(deviceId);
            if(result==1){
                System.out.println("删除CompensationDevice成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("CableSensingDevice")){
            int result = deviceService.delCableSensingDevice(deviceId);
            if(result==1){
                System.out.println("删除CableSensingDevice成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("ThreePhaseMeter")){
            int result = deviceService.delThreePhaseMeter(deviceId);
            if(result==1){
                System.out.println("删除ThreePhaseMeter成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }else if(deviceName.equals("Terminal")){
            int result = deviceService.delTerminal(deviceId);
            if(result==1){
                System.out.println("删除Terminal成功！！");
            }
            return "{\"delMsg\":\"1\"}";
        }

        return "{\"delMsg\":\"0\"}";
    }

    //添加设备
    @PostMapping(value="/addDevice",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addDevice(String deviceName,String deviceJson)throws  Exception{
        System.out.println("需要添加的设备名："+deviceName);
        System.out.println("收到需要添加的数据："+deviceJson);
        if(deviceName.equals("Transformer")){
            //将json字符串转换成实体类对象
            Transformer transformer =JSON.parseObject(deviceJson,Transformer.class);
            int addResult = deviceService.addTransformer(transformer);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+transformer.getId());
                System.out.println("设备参数:"+transformer);
                return "{\"Transformer\":"+ JSON.toJSONString(transformer) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("EvSensor")){
            //将json字符串转换成实体类对象
            EvSensor evSensor =JSON.parseObject(deviceJson,EvSensor.class);
            int addResult = deviceService.addEvSensor(evSensor);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+evSensor.getId());
                System.out.println("设备参数:"+evSensor);
                return "{\"EvSensor\":"+ JSON.toJSONString(evSensor) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("AreaMeter")){
            //将json字符串转换成实体类对象
            AreaMeter areaMeter =JSON.parseObject(deviceJson,AreaMeter.class);
            int addResult = deviceService.addAreaMeter(areaMeter);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+areaMeter.getId());
                System.out.println("设备参数:"+areaMeter);
                return "{\"AreaMeter\":"+ JSON.toJSONString(areaMeter) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("Fuse")){
            //将json字符串转换成实体类对象
            Fuse fuse =JSON.parseObject(deviceJson,Fuse.class);
            int addResult = deviceService.addFuse(fuse);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+fuse.getId());
                System.out.println("设备参数:"+fuse);
                return "{\"Fuse\":"+ JSON.toJSONString(fuse) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("IntelligentSwitch")){
            //将json字符串转换成实体类对象
            IntelligentSwitch intelligentSwitch =JSON.parseObject(deviceJson,IntelligentSwitch.class);
            int addResult = deviceService.addIntelligentSwitch(intelligentSwitch);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+intelligentSwitch.getId());
                System.out.println("设备参数:"+intelligentSwitch);
                return "{\"IntelligentSwitch\":"+ JSON.toJSONString(intelligentSwitch) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("UniphaseMeter")){
            //将json字符串转换成实体类对象
            UniphaseMeter uniphaseMeter =JSON.parseObject(deviceJson,UniphaseMeter.class);
            int addResult = deviceService.addUniphaseMeter(uniphaseMeter);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+uniphaseMeter.getId());
                System.out.println("设备参数:"+uniphaseMeter);
                return "{\"UniphaseMeter\":"+ JSON.toJSONString(uniphaseMeter) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("LTUSwitch")){
            //将json字符串转换成实体类对象
            LTUSwitch ltuSwitch =JSON.parseObject(deviceJson,LTUSwitch.class);
            int addResult = deviceService.addLTUSwitch(ltuSwitch);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+ltuSwitch.getId());
                System.out.println("设备参数:"+ltuSwitch);
                return "{\"LTUSwitch\":"+ JSON.toJSONString(ltuSwitch) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("ChangePhaseSwitch")){
            //将json字符串转换成实体类对象
            ChangePhaseSwitch changePhaseSwitch =JSON.parseObject(deviceJson,ChangePhaseSwitch.class);
            int addResult = deviceService.addChangePhaseSwitch(changePhaseSwitch);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+changePhaseSwitch.getId());
                System.out.println("设备参数:"+changePhaseSwitch);
                return "{\"ChangePhaseSwitch\":"+ JSON.toJSONString(changePhaseSwitch) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("ChargingFacility")){
            //将json字符串转换成实体类对象
            ChargingFacility chargingFacility =JSON.parseObject(deviceJson,ChargingFacility.class);
            int addResult = deviceService.addChargingFacility(chargingFacility);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+chargingFacility.getId());
                System.out.println("设备参数:"+chargingFacility);
                return "{\"ChargingFacility\":"+ JSON.toJSONString(chargingFacility) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("PvUser")){
            //将json字符串转换成实体类对象
            PvUser pvUser =JSON.parseObject(deviceJson,PvUser.class);
            int addResult = deviceService.addPvUser(pvUser);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+pvUser.getId());
                System.out.println("设备参数:"+pvUser);
                return "{\"PvUser\":"+ JSON.toJSONString(pvUser) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("CompensationDevice")){
            //将json字符串转换成实体类对象
            CompensationDevice compensationDevice =JSON.parseObject(deviceJson,CompensationDevice.class);
            int addResult = deviceService.addCompensationDevice(compensationDevice);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+compensationDevice.getId());
                System.out.println("设备参数:"+compensationDevice);
                return "{\"CompensationDevice\":"+ JSON.toJSONString(compensationDevice) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("CableSensingDevice")){
            //将json字符串转换成实体类对象
            CableSensingDevice cableSensingDevice =JSON.parseObject(deviceJson,CableSensingDevice.class);
            int addResult = deviceService.addCableSensingDevice(cableSensingDevice);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+cableSensingDevice.getId());
                System.out.println("设备参数:"+cableSensingDevice);
                return "{\"CableSensingDevice\":"+ JSON.toJSONString(cableSensingDevice) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("ThreePhaseMeter")){
            //将json字符串转换成实体类对象
            ThreePhaseMeter threePhaseMeter =JSON.parseObject(deviceJson,ThreePhaseMeter.class);
            int addResult = deviceService.addThreePhaseMeter(threePhaseMeter);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+threePhaseMeter.getId());
                System.out.println("设备参数:"+threePhaseMeter);
                return "{\"ThreePhaseMeter\":"+ JSON.toJSONString(threePhaseMeter) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }else if(deviceName.equals("Terminal")){
            //将json字符串转换成实体类对象
            Terminal terminal =JSON.parseObject(deviceJson,Terminal.class);
            int addResult = deviceService.addTerminal(terminal);
            if(addResult==1){//添加成功后返回设备Id(供修改设备参数)
                System.out.println("添加设备返回的ID:"+terminal.getId());
                System.out.println("设备参数:"+terminal);
                return "{\"Terminal\":"+ JSON.toJSONString(terminal) +"," +
                        "\"addMsg\":\"1\"}";
            }
        }
        return "{\"addMsg\":\"0\"}";
    }


    @PostMapping("/countDeviceByCourtsId")
    @ResponseBody
    public Object countDeviceByCourtsId(int courtsId)throws Exception{
        System.out.println("获取到的台区id:"+courtsId);
        int countArr[] = new int[14];
        if(courtsId==0){//获取所有该设备总数
            countArr[0] = deviceService.countTransformer();
            countArr[1] = deviceService.countEvSensor();
            countArr[2] = deviceService.countAreaMeter();
            countArr[3] = deviceService.countFuse();
            countArr[4] = deviceService.countIntelligentSwitch();
            countArr[5] = deviceService.countUniphaseMeter();
            countArr[6] = deviceService.countLTUSwitch();
            countArr[7] = deviceService.countChangePhaseSwitch();
            countArr[8] = deviceService.countChargingFacility();
            countArr[9] = deviceService.countPvUser();
            countArr[10] = deviceService.countCompensationDevice();
            countArr[11] = deviceService.countCableSensingDevice();
            countArr[12] = deviceService.countThreePhaseMeter();
            countArr[13] = deviceService.countTerminal();
        }else{
            countArr[0] = deviceService.countTransformerByCourtsId(courtsId);
            countArr[1] = deviceService.countEvSensorByCourtsId(courtsId);
            countArr[2] = deviceService.countAreaMeterByCourtsId(courtsId);
            countArr[3] = deviceService.countFuseByCourtsId(courtsId);
            countArr[4] = deviceService.countIntelligentSwitchByCourtsId(courtsId);
            countArr[5] = deviceService.countUniphaseMeterByCourtsId(courtsId);
            countArr[6] = deviceService.countLTUSwitchByCourtsId(courtsId);
            countArr[7] = deviceService.countChangePhaseSwitchByCourtsId(courtsId);
            countArr[8] = deviceService.countChargingFacilityByCourtsId(courtsId);
            countArr[9] = deviceService.countPvUserByCourtsId(courtsId);
            countArr[10] = deviceService.countCompensationDeviceByCourtsId(courtsId);
            countArr[11] = deviceService.countCableSensingDeviceByCourtsId(courtsId);
            countArr[12] = deviceService.countThreePhaseMeterByCourtsId(courtsId);
            countArr[13] = deviceService.countTerminalByCourtsId(courtsId);
        }



        return countArr;
    }


    @PostMapping("/addCheck")
    @ResponseBody
    public String addCheck(String checkJson)throws Exception{
        System.out.println("获取到的信息："+checkJson);
        CheckData checkData = JSON.parseObject(checkJson,CheckData.class);
        System.out.println("获取到的信息："+checkData);
        int result = deviceService.addCheck(checkData);
        if(result==1){
            return "{\"addMsg\":\"1\"}";
        }
        return "{\"addMsg\":\"0\"}";
    }

    @PostMapping(value="/findAllCheck",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String findAllCheck( )throws Exception{
        List<CheckData> checkDataList = deviceService.findAllCheck();
        return JSON.toJSONString(checkDataList) ;
    }

    @PostMapping(value="/findCheckById", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ResponseObj findCheckById(Integer checkId )throws Exception{
        return deviceService.findCheckById(checkId);
    }


    /*台区基本信息*/
    @PostMapping("/addBaseInfo")
    @ResponseBody
    public ResponseObj addBaseInfo(BaseInfo baseInfo){
        return baseInfoService.addBaseInfo(baseInfo);
    }

    @PostMapping("/findBaseInfoByCourtId")
    @ResponseBody
    public ResponseObj findBaseInfoByCourtId(Integer courtId){
        return baseInfoService.getBaseInfoByCourtId(courtId);
    }

    @PostMapping("/getBaseInfoByTimeAndCourtId")
    @ResponseBody
    public ResponseObj getBaseInfoByTimeAndCourtId(String time, Integer courtId){
        return baseInfoService.getBaseInfoByTimeAndCourtId(time, courtId);
    }

    @PostMapping("/getAllBaseInfo")
    @ResponseBody
    public ResponseObj getAllBaseInfo(){
        return baseInfoService.getAllBaseInfo();
    }

    @PostMapping("/getBaseInfoCourtIdAndCourName")
    @ResponseBody
    public ResponseObj getBaseInfoCourtIdAndCourName(){
        return baseInfoService.getBaseInfoCourtIdAndCourName();
    }

    @PostMapping("/updateBaseInfo")
    @ResponseBody
    public ResponseObj updateBaseInfo(BaseInfo baseInfo){
        return baseInfoService.updateBaseInfo(baseInfo);
    }


}
