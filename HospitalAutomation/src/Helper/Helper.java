package Helper;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {
	
	public static void changeOptionButtonText() {
		UIManager.put("OptionPane.cancelButtonText", "No, cancel!");
		UIManager.put("OptionPane.cancelButtonText", "No!");
		UIManager.put("OptionPane.cancelButtonText", "OK!");
		UIManager.put("OptionPane.cancelButtonText", "Yes!");
	}
	public static void showMessage(String str) {
		String message;
		changeOptionButtonText();
		
		switch (str) {
		case "fill":
			message = "Please fill out all the fields!";
			break;
		case "success":
			message = "Successfully done!";
			break;
		case "error":
			message = "Failed!";
			break;
		default:
			message = str;
		}
		JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
	}
	public static boolean confirm(String str) {
		String msg;
		changeOptionButtonText();
		
		switch (str) {
		case "sure": {
			msg = "Are you sure?";
			break;
		}
		default:
			msg = str;
		}
		int result = JOptionPane.showConfirmDialog(null, msg, "Warning!", JOptionPane.YES_NO_OPTION);
		if (result == 0) {
			return true;
		}else {
			return false;
			}
		}
	}
