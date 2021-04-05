import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return MyAppState();
  }
}

class MyAppState extends State<MyApp> {
  TextEditingController controller = TextEditingController();
  var urlStr = "https://google.com";
  void launchUrl() {
    setState(() {
      urlStr = controller.text;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: ' Browse through WebView',
      // theme: ThemeData(
      //   primarySwatch: Colors.blue,
      // ),
      home: Scaffold(
        appBar: AppBar(
          title: TextField(
            autofocus: false,
            controller: controller,
            cursorColor: Colors.white,
            cursorWidth: 0.3,
            textInputAction: TextInputAction.go,
            onSubmitted: (url) => launchUrl,
            style: TextStyle(color: Colors.white),
            decoration: InputDecoration(
              border: InputBorder.none,
              hintText: "Enter URL here",
              hintStyle: TextStyle(color: Colors.white),
            ),
          ),
          actions: <Widget>[
            IconButton(
              icon: Icon(Icons.navigate_next),
              onPressed: () => launchUrl(),
            )
          ],
        ),
        body: WebView(
          initialUrl: urlStr,
          javascriptMode: JavascriptMode.unrestricted,
        ),
      ),
    );
  }
}
