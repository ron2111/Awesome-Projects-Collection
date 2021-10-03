import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'DeviceSize.dart';

class Loading extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: SpinKitHourGlass(
          color: Colors.cyanAccent,
          size: displayWidth(context) * 0.1,
        ),
      ),
    );
  }
}

class Loading2 extends StatelessWidget {
  const Loading2({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: SpinKitCircle(
          color: Colors.yellow[200],
          size: displayWidth(context) * 0.1,
        ),
      ),
    );
  }
}
