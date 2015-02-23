package phantom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PhantomjsProj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		runCommand("phantomjs --ignore-ssl-errors=yes D:/phantomjs-2.0.0-windows/bin/hello.js");
		//THen>> start "" "https://ip-for-fortigate"
	}

public static void runCommand(String cmd){
try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(cmd);

			BufferedReader r = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
			proc.waitFor();
			int exitVal = proc.exitValue();
			System.out.println("Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}

}
}
