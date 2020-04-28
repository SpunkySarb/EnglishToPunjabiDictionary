package application;



import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SampleController {
	@FXML
	public static String searchs ;

	 @FXML
	    private Pane borderPane;

	    @FXML
	    private TextField getWord;

	    @FXML
	    private Button search;

	    @FXML
	    private ListView<String> List;
	    
	    @FXML
	   
   
    public  void Dictionary()    {
		// TODO Auto-generated method stub

		List.getItems().clear();
		
		try {
			//System.out.print("Welcome to English to Punjabi Dictionary\n\nEnter English Word :");
			//search = input.nextLine();
			String searchs = getWord.getText();
			
			//String searchs = getWord.getText();
			//System.out.println(searchs);
			Document doc = Jsoup.connect("https://www.shabdkosh.com/search-dictionary?e="+searchs+"&lc=pa&sl=en&tl=pa").userAgent("mozilla/17.0").get();
		
			Elements temp=doc.select("ol.eirol li ");
		@SuppressWarnings("unused")
		int i=0;
		for (Element punjabi:temp) {
			i++;
			try{
				
				 
				
				
				
				
				String result = " \n"+punjabi.getElementsByTag("li").first().text();
				//System.out.println(result);
			
			List.getItems().add(result);
			
			//System.out.println(result);
			}catch(java.lang.NullPointerException e) {
				System.out.println("");
			}
		}
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

