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
            backgroundColor: Colors.blue,
            titleTextStyle: const TextStyle(
              color: Colors.white,
              fontSize: 20,
            ),
            elevation: 20,
          ),
          body: const Center(
            child: Text(
              "Hello World",
              style: TextStyle(fontSize: 40.0),
            ),
          )),
    );
  }
}
