import 'package:flutter/material.dart';

void main() {
  runApp(
      const MaterialApp(
        title: "Stateful App",
        home: FavoriteCity(),
      )
  );
}

class FavoriteCity extends StatefulWidget {
  const FavoriteCity({super.key});

  @override
  State<StatefulWidget> createState() {
    return _FavoriteCityState();
  }
}

class _FavoriteCityState extends State<FavoriteCity> {
  String nameCity = "";
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Stateful App Example"),
      ),
      body: Container(
        margin: const EdgeInsets.all(20.0),
        child: Column(
          children: <Widget>[
            TextField(
              onChanged: (String userInput) {
                setState(() {
                  nameCity = userInput;
                });
              },
            ),
            Padding(padding: const EdgeInsets.all(30.0),
            child: Text(
              "Your city is $nameCity",
              style: const TextStyle(fontSize: 20.0),
            ),)
          ],
        ),
      ),
    );
    throw UnimplementedError();
  }
}