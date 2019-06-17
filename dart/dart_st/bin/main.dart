
import 'dart:io';
import 'package:dart_st/dart_st.dart' as dart_st;

main(List<String> arguments) async {
  print('Hello world: ${dart_st.calculate()}!');
   var  resp =  asy();
  print("------end-----");
  print(resp);
}



Future<String> asy() async{
   var httpClient = new HttpClient();
  var uri = new Uri.http('baidu.com',"",{});
  var request = await httpClient.getUrl(uri);
  var response = await request.close();
  return response.toString();
}
