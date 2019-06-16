
import 'dart:io';
import 'package:dart_st/dart_st.dart' as dart_st;

main(List<String> arguments) {
  print('Hello world: ${dart_st.calculate()}!');
  //asy();
  print("------end-----");
}



void asy() async{
   var httpClient = new HttpClient();
  var uri = new Uri.http(
      'example.com', '/path1/path2', {'param1': '42', 'param2': 'foo'});
  var request = await httpClient.getUrl(uri);
  var response = await request.close();
  print(response);
}
