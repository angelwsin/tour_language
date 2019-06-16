import 'package:flutter/material.dart';

import 'MyAppBar.dart';
import 'RandomWords.dart';
import 'TutorialHome.dart';

void main() => /*runApp(MyApp());*/runApp(new MaterialApp(
    title: 'My app', // used by the OS task switcher
    home: new TutorialHome(),
  ));

//开始必须是StatelessWidget的类型
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    //final wordPair = new WordPair.random();
    /*return new MaterialApp(
      title: 'Welcome to Flutter',
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('Welcome to Flutter'),
        ),
        body: new Center(
          //child: new Text('Hello World'),
          //child: new Text(wordPair.asPascalCase),
          child: new RandomWords(),
        ),
      ),
    );*/

    return new MaterialApp(
      title: 'Startup Name Generator',
      //更改主题
      theme: new ThemeData(
        primaryColor: Colors.white,
      ),
      home: new RandomWords(),
    );
  }
}