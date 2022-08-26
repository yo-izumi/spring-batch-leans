# spring-batch-learns
スプリングバッチ確認用
Taskletを利用して、OpenMeteoAPIを呼び出してデータをDBへ保存するサンプル。
現実装では、SimpleJobLauncherは使用していない。BatchLancherクラスをコメントアウトするとSimpleJobLauncherで実行できる
またmain関数では、1パス実行にしてあるので、コメントアウトしてある部分に戻すと待機状態でCron指定した時間で実行できる

* [Spring Initilizr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.7.2&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=openMeteoDownload&name=openMeteoDownload&description=open%20meteo%20data%20download&packageName=com.example.openMeteoDownload&dependencies=lombok,batch,postgresql,data-jpa,web)

* [Postgres]
DockerDesktopからlatestをそのまま作成して利用。
