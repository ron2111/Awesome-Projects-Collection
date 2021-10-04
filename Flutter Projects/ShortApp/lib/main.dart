import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    title: "ShortApp",
    home: MyApp(),
    theme: ThemeData(accentColor: Colors.red, primaryColor: Colors.deepOrange),
  ));
}

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MyAppState();
  }
}

class _MyAppState extends State<MyApp> {
  String name = "";
  var _country = ['Select', 'India', 'US', 'Russia', 'Japan', 'China'];
  var _currentItemSelected = 'India';
  var _phnum = "";
  var _cont = "";
  String _ch = "";
  //String _launchUrl = "https://wa.me/+919110096745";
  //final contCon = new TextEditingController();
  final phnumCon = new TextEditingController();

  Future<void> _whatsApp(String url) async {
    if (await canLaunch(url)) {
      await launch(url);
      throw '$url';
    } else {
      throw 'Could not launch $url';
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('ShortApp'),
      ),
      body: Container(
        child: Padding(
          padding: EdgeInsets.only(left: 5.0, right: 5.0, top: 170.0),
          child: Column(
            children: <Widget>[
              Row(
                children: <Widget>[
                  DropdownButton<String>(
                    items: _country.map((String dropDownStringItem) {
                      return DropdownMenuItem<String>(
                        value: dropDownStringItem,
                        child: Text(dropDownStringItem),
                      );
                    }).toList(),
                    onChanged: (String newValSel) {
                      setState(() {
                        this._currentItemSelected = newValSel;
                        _cont = _currentItemSelected;
                      });
                    },
                    value: _currentItemSelected,
                  ),
                  Expanded(
                    child: Padding(
                      padding: EdgeInsets.only(left: 10.0, right: 5.0),
                      child: TextField(
                        controller: phnumCon,
                        keyboardType: TextInputType.number,
                        decoration: InputDecoration(
                          labelText: 'Phone Number',
                          hintText: 'Enter Ph no.',
                          border: OutlineInputBorder(
                              borderRadius: BorderRadius.circular(5.0)),
                        ),
                      ),
                    ),
                  ),
                ],
              ),
              Padding(
                padding: EdgeInsets.only(left: 90.0, right: 90.0, top: 30.0),
                child: Row(
                  children: <Widget>[
                    Expanded(
                      child: RaisedButton(
                        textColor: Colors.white,
                        color: Colors.deepOrange,
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(18.0),
                            side: BorderSide(color: Colors.white12)),
                        child: Text('Submit'),
                        onPressed: () {
                          setState(() {
                            _phnum = phnumCon.text;

                            if (_cont == 'Japan') {
                              _ch = "+81";
                            } else if (_cont == 'India') {
                              _ch = "+91";
                            } else if (_cont == 'China') {
                              _ch = "+86";
                            } else if (_cont == 'US') {
                              _ch = "+1";
                            } else if (_cont == 'Russia') {
                              _ch = "+7";
                            }
                            _whatsApp('https://wa.me/$_ch$_phnum');
                          });
                        },
                      ),
                    )
                  ],
                ),
              ),
              //Text('Your country name is $_cont and Phone number is $_phnum'),
            ],
          ),
        ),
      ),
    );
  }
}
