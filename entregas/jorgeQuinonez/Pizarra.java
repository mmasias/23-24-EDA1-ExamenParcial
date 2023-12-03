public class Pizarra {

 private String message;

 public String getMessage() {
  return message;
 }

 public void writeMessage(String message) {
  this.message = message;
 }

 public void clear() {
  this.message = null;
 }

}
