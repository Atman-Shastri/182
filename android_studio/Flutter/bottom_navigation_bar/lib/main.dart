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

const TextStyle textStyle =
    TextStyle(fontWeight: FontWeight.bold, fontSize: 40);

class ProductBox extends StatelessWidget {
  const ProductBox({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
        padding: const EdgeInsets.all(2),
        height: 120,
        child: const Card(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              Image(
                  image: AssetImage(
                    'images/space.jpg',
                  ),
                  height: 1200,
                  width: 1200),
              Expanded(
                  child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  Text(
                    "Product",
                    style: textStyle,
                  ),
                  Text("Description", style: textStyle),
                  Text("Price: 29,999", style: textStyle)
                ],
              ))
            ],
          ),
        ));
    throw UnimplementedError();
  }
}
