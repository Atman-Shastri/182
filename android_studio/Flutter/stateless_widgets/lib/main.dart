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
        title: const Text("Welcome to Flutter"),
      ),
      body: Container(
        margin: const EdgeInsets.all(20),
        child: const Text(
          "Welcome to Flutter",
          style: TextStyle(fontSize: 20.0),
        ),
      ),
    ));
  }
}
