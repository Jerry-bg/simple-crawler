### A Simple Crawler Framework

* **简介**

  一个基于阻塞队列的爬虫框架

* **框架介绍**

  > 框架流程图

  ![crawler.png](https://github.com/Jerry-bg/simple-crawler/image/crawler.png)

  > 架包功能

  `@com.kons.request`:封装请求的头部信息

  `@com.kons.response`:封装处理过的请求响应信息

  `@com.kons.schedule`:框架的调度器，主要是存储请求，以及处理过的响应信息

  `@com.kons.downloader`:框架的下载器，处理请求队列的请求信息

  `@com.kons.processor`:框架的处理器，处理响应信息队列中的数据，框架提供了默认的处理器，											也可以自定义实现处理器