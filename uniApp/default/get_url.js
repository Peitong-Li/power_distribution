export const config_url = {
  baseurl:'http://192.168.167.230:8091/power_distribution/'
}

window.configIp = function(IP){
	config_url.baseurl = "http://" + IP + ":8091/power_distribution/"
}
