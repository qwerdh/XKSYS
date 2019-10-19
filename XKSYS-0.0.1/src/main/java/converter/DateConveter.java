package converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
public class DateConveter implements Converter<String, Date>{

	public Date convert(String source) {
		// TODO Auto-generated method stub
		try {
			if(null != source){//2016:11-05 11_43-50
				DateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				return df.parse(source);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
