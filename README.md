# weatherssss

##restTemplate和httpclient
###本项目是使用的httpclinet来充当restTemplate的实例的，这里的restTemplate相当于一个jdbcTemplate模板一样的，需要具体的实例
https://www.hifreud.com/2017/07/06/spring-boot-16-call-rest-services/
##关于使用jackson把json转化为java对象一直失败，Unrecognized field, not marked as ignorable
###因为来使一直没有使用@JosnIgnoreProperties和JsonProperty两个注解，所以，我的项目一直报错，加上之后就解决了，@JosnProperty是把json字符串解析为具体的字段
## redis
### 刚刚第一次启动redis时候 是一闪而过，然后试了一下网上的解决办法，真的可以了
https://blog.csdn.net/qq_40361770/article/details/80454248
### redis其他的知识点 redis.window.conf里面的bind 127.0.0.1 指定是只允许本机访问，requirepass 是配置密码  原来我一直没有配置本机redis的密码  最好配置一下安全。之后 我发现了一个问题，只要直接点击redisserverexe即使你配置了密码，也是没有用的，只有redis-server redis.windows.conf才能使得密码生效

## 使用 @Sheduled这个注解还有一定的要求的 core  fixedrate fixedDelay三者之间是不可以共存的 