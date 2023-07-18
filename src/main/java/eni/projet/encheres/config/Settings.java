package eni.projet.encheres.config;


	import java.io.IOException;
	import java.util.Properties;

	public class Settings {
		
		
		private static Properties properties = new Properties();// lazy declaration
		
		static {
			try {			
				properties.load(Settings.class.getResourceAsStream("setting.properties") );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String getProperty(String key) {
			return properties.getProperty(key);
		}

	}
