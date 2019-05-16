# weatherssss

##restTemplate和httpclient
###本项目是使用的httpclinet来充当restTemplate的实例的，这里的restTemplate相当于一个jdbcTemplate模板一样的，需要具体的实例
https://www.hifreud.com/2017/07/06/spring-boot-16-call-rest-services/
##关于使用jackson把json转化为java对象一直失败，Unrecognized field, not marked as ignorable
###因为来使一直没有使用@JosnIgnoreProperties和JsonProperty两个注解，所以，我的项目一直报错，加上之后就解决了，@JosnProperty是把json字符串解析为具体的字段