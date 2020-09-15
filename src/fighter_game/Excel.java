package fighter_game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.ByteArrayOutputStream;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URLEncoder;

//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	private File writename;
	Excel() {
		writename = new File("save_file.txt");
	}

	public void read(fighter fighter, int[] Infinite_history_stage, int[] money, ability_UI Ability, store store,
			int setrow) {
		try {
//			FileReader fr = new FileReader(Excel.class.getResource("test.txt").getFile());
			FileReader fr = new FileReader("save_file.txt");
			BufferedReader br = new BufferedReader(fr);
			int i = 0;

			String str = null;
			while (i < 13 && (str = br.readLine()) != null) {
				System.out.println(str);
				if (i == 0)
					fighter.setMax_Hp(Integer.valueOf(str));
				if (i == 1)
					fighter.setExp(Integer.valueOf(str));
				if (i == 2)
					fighter.setLvup_Exp(Integer.valueOf(str));
				if (i == 3)
					money[0] = Integer.valueOf(str);
				if (i == 4)
					fighter.setLv(Integer.valueOf(str));
				if (i == 5)
					Ability.AP = Integer.valueOf(str);
				if (i == 6)
					Ability.ability[0] = Integer.valueOf(str);
				if (i == 7)
					Ability.ability[1] = Integer.valueOf(str);
				if (i == 8)
					Ability.ability[2] = Integer.valueOf(str);
				if (i == 9)
					Ability.ability[3] = Integer.valueOf(str);
				if (i == 10)
					store.WeaponLV = Integer.valueOf(str);
				if (i == 11)
					store.Bomb = Integer.valueOf(str);
				if (i == 12)
					Infinite_history_stage[0] = Integer.valueOf(str);
				System.out.println("done" + i);
				i++;
				fr.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("load_in done");
	}

	public void set(fighter fighter, int[] Infinite_history_stage, int[] money, ability_UI Ability, store store) {
		try {
//			File writename = new File(Excel.class.getResource("test.txt").getFile()); // Ã§â€ºÂ¸Ã¥Â°ï¿½Ã¨Â·Â¯Ã¥Â¾â€˜Ã¯Â¼Å’Ã¥Â¦â€šÃ¦Å¾Å“Ã¦Â²â€™Ã¦Å“â€°Ã¥â€°â€¡Ã¨Â¦ï¿½Ã¥Â»ÂºÃ§Â«â€¹Ã¤Â¸â‚¬Ã¥â‚¬â€¹Ã¦â€“Â°Ã§Å¡â€žoutputÃ£â‚¬â€štxtÃ¦Âªâ€�Ã¦Â¡Ë†
//			File writename = new File("test.txt");
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
//			System.out.println(writename2); 
//			writename2.createNewFile(); 
			out.write(String.valueOf((int) fighter.getHp()));	//0
			out.newLine();
			out.write(String.valueOf((int)fighter.getExp()));	//1
			out.newLine();
			out.write(String.valueOf((int)fighter.getLvup_Exp()));	//2
			out.newLine();
			out.write(String.valueOf(money[0]));	//3
			out.newLine();	
			out.write(String.valueOf(fighter.getLv()));	//4
			out.newLine();
			out.write(String.valueOf(Ability.AP));//5
			out.newLine();
			out.write(String.valueOf(Ability.ability[0]));//6
			out.newLine();
			out.write(String.valueOf(Ability.ability[1]));//7
			out.newLine();
			out.write(String.valueOf(Ability.ability[2]));//8
			out.newLine();
			out.write(String.valueOf(Ability.ability[3]));//9
			out.newLine();
			out.write(String.valueOf(store.WeaponLV));//10
			out.newLine();
			out.write(String.valueOf(store.Bomb));//11
			out.newLine();
			out.write(String.valueOf(Infinite_history_stage[0]));//12
			out.newLine();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
