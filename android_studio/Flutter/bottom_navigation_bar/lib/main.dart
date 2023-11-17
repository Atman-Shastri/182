import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: "Product Box",
      home: ProductBox(),
    );
    throw UnimplementedError();
  }
}

class ProductBox extends StatelessWidget {
  const ProductBox({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
        padding: const EdgeInsets.all(2),
        height: 120,
        child: Card(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              const Image(
                  image: AssetImage(
                    'images/space.jpg',
                  ),
                  height: 1200,
                  width: 1200),
              Expanded(
                  child: Container(
                child: const Column(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: <Widget>[
                    Text(
                      "Product",
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                    Text("Description"),
                    Text("Price: 50")
                  ],
                ),
              ))
            ],
          ),
        ));
    throw UnimplementedError();
  }
}
