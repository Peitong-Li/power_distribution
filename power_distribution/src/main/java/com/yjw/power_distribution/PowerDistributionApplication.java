package com.yjw.power_distribution;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PowerDistributionApplication {

    public static void function(String str) {
        char[] charArr_1 = str.toCharArray();
        char[] charArr_2;
        for(int i=0;i<1;i++){
            //判断是否
            if(!Character.isLowerCase(charArr_1[i])){
                System.out.println("大写");
            }else{
                System.out.println("小写");
            }

        }

        //输入：myFirstName
        //输出：my_first_name
        //
        //
        //例子 2
        //输入：OnlineUsers
        //输出：online_users
        //
        //
        //例子 3
        //输入：Address
        //输出：address
        //
        //
        //例子 4
        //输入：validHTTPRequest
        //输出：valid_http_request


        // TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		String str_1 = scanner.next();
//		int a = conversion(5,2);


    }

    public static void main(String[] args) {
        SpringApplication.run(PowerDistributionApplication.class, args);
    }
}
