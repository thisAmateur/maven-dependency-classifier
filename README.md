# maven-dependency-classifier
将maven工程依赖的jar包进行分类的小工具。

默认分类规则是按依赖关系分类。

### Example：
通过 mvn dependency:tree > ./dependency.tree 得到如下的依赖关系：

    [INFO] Scanning for projects...
    [INFO]                                                                         
    [INFO] ------------------------------------------------------------------------
    [INFO] Building springguide 0.0.1-SNAPSHOT
    [INFO] ------------------------------------------------------------------------
    [INFO] 
    [INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ springguide ---
    [INFO] com.thisamateur.test:springguide:jar:0.0.1-SNAPSHOT
    [INFO] +- junit:junit:jar:4.12:test
    [INFO] |  \- org.hamcrest:hamcrest-core:jar:1.3:test
    [INFO] \- org.springframework:spring-context:jar:4.3.4.RELEASE:compile
    [INFO]    +- org.springframework:spring-aop:jar:4.3.4.RELEASE:compile
    [INFO]    +- org.springframework:spring-beans:jar:4.3.4.RELEASE:compile
    [INFO]    +- org.springframework:spring-core:jar:4.3.4.RELEASE:compile
    [INFO]    |  \- commons-logging:commons-logging:jar:1.2:compile
    [INFO]    \- org.springframework:spring-expression:jar:4.3.4.RELEASE:compile
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 1.381 s
    [INFO] Finished at: 2018-02-19T14:04:40+08:00
    [INFO] Final Memory: 11M/155M
    [INFO] ------------------------------------------------------------------------

通过 mvn dependency:copy-dependencies 得到上述springguide样例工程的所有依赖jar包：

    jarRepoPath
    |- commons-logging-1.2.jar
    |- hamcrest-core-1.3.jar
    |- junit-4.12.jar
    |- spring-aop-4.3.4.RELEASE.jar
    |- spring-beans-4.3.4.RELEASE.jar
    |- spring-context-4.3.4.RELEASE.jar
    |- spring-core-4.3.4.RELEASE.jar
    \- spring-expression-4.3.4.RELEASE.jar

经过归类之后的jar包目录：

    targetBasePath
    \- springguide-0.0.1-SNAPSHOT
       |- junit-4.12.jar
       |- spring-context-4.3.4.RELEASE.jar
       |- junit-4.12
          \- hamcrest-core-1.3.jar
       \- spring-context-4.3.4.RELEASE
          |- spring-aop-4.3.4.RELEASE.jar
          |- spring-beans-4.3.4.RELEASE.jar
          |- spring-core-4.3.4.RELEASE.jar
          |- spring-expression-4.3.4.RELEASE.jar
          \- spring-core-4.3.4.RELEASE
             \- commons-logging-1.2.jar

### Change-log
2018-2-23

1.  完善部分注释
2.  完善README