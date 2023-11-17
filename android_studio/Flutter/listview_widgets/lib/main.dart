import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text("ListView Example"),
        ),
        body: const ListData(),
      ),
    );
    throw UnimplementedError();
  }
}

class ListData extends StatelessWidget {
  const ListData({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: ListView(
      children: const <Widget>[
        ListTile(
          leading: Icon(Icons.map),
          title: Text("Map"),
        ),
        ListTile(
          leading: Icon(Icons.phone_android),
          title: Text("Phone"),
        ),
        ListTile(
          leading: Icon(Icons.photo_album),
          title: Text("Album"),
        )
      ],
    ));
    throw UnimplementedError();
  }
}
