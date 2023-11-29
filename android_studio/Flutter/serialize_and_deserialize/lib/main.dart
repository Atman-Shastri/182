import 'dart:convert';

import 'package:flutter/material.dart';

import 'UserModel.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  UserModel userObject = UserModel(
      id: "182",
      fullname: "Atman Shastri",
      email: "atmanshastri@gmail.com",
      percentage: "51 %");
  String userJSON =
      '{"id": "182", "fullname": "Atman Shastri", "email":"atmanshastri@gmail.com", "percentage":"51 %"}';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("JSON Operations"),
        backgroundColor: Colors.blue,
        centerTitle: true,
        titleTextStyle: const TextStyle(
          color: Colors.white,
          fontSize: 20,
        ),
        elevation: 20,
      ),
      body: Center(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
              onPressed: () {
                //Serialization (Object to JSON)
                //1. Convert Object to Map -> 2. Map to JSON
                Map<String, dynamic> userMap = userObject.toMap();
                var json = jsonEncode(userMap);
                print(json.toString());
              },
              child: const Text(
                "Serialize",
                style: TextStyle(fontSize: 30),
              ),
            ),
            const SizedBox(
              width: 20,
            ),
            ElevatedButton(
                onPressed: () {
                  //De-Serialization (JSON to Object)
                  //1. Convert Map to JSON -> 2. Object to Map
                  var decode = jsonDecode(userJSON);
                  Map<String, dynamic> userMap = decode;
                  UserModel newuser = UserModel.fromMap(userMap);
                  print(
                      "Name: ${newuser.fullname}, Percentage: ${newuser.percentage}");
                },
                child: const Text(
                  "Deserialize",
                  style: TextStyle(fontSize: 30),
                )),
          ],
        ),
      ),
    );
  }
}
