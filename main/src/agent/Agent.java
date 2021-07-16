package agent;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Agent {

	public static ArrayList<String> classesToTransform = new ArrayList<>();

	public static void agentmain(final String args, final Instrumentation instrumentation) throws Exception {
		instrumentation.addTransformer(new Transformer(), true);
		Arrays.stream(instrumentation.getAllLoadedClasses()).forEach(aClass -> {
			if (aClass.getName().equals("net.minecraft.o9") || aClass.getName().equals("net.minecraft.ca") || aClass.getName().equals("net.minecraft.r3") || aClass.getName().equals("fI") || aClass.getName().equals("iZ") || aClass.getName().equals("net.minecraft.rb") || aClass.getName().equals("net.minecraft.client.iN") || aClass.getName().equals("net.minecraft.client.cv") || aClass.getName().equals("net.minecraft.client.iW") || aClass.getName().equals("Hook")) {
				try {
					instrumentation.retransformClasses(aClass);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}
}
