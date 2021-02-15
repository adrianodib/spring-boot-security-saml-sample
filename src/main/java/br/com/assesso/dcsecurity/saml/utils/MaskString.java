package br.com.assesso.dcsecurity.saml.utils;

import org.apache.commons.lang3.StringUtils;

public class MaskString {

	public static void main(String[] args) throws Exception {

		String str = "1234567812345678";
		
		// mask first 4 characters
		System.out.println(maskString(str, 0, 4, '*'));

		// mask everything but last 4 digits
		System.out.println(maskString(str, 0, 12, '*'));

		// mask everything
		System.out.println(maskString(str, 0, str.length(), '*'));

		// mask everything but first and last 4 digits
		System.out.println(maskString(str, 1, 12, '*'));

	}
	
	public static String maskPhoneNumber(String phoneNumber) {

		String retorno = "";
		
		if (StringUtils.isNotBlank(phoneNumber)) {
			try {
				retorno = (maskString(phoneNumber, 0, 9, '*'));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return retorno;
	}
	
	private static String maskString(String strText, int start, int end, char maskChar) throws Exception{
	        
	        if(strText == null || strText.equals(""))
	            return "";
	        
	        if(start < 0)
	            start = 0;
	        
	        if( end > strText.length() )
	            end = strText.length();
	            
	        if(start > end)
	            throw new Exception("End index cannot be greater than start index");
	        
	        int maskLength = end - start;
	        
	        if(maskLength == 0)
	            return strText;
	        
	        StringBuilder sbMaskString = new StringBuilder(maskLength);
	        
	        for(int i = 0; i < maskLength; i++){
	            sbMaskString.append(maskChar);
	        }
	        
	        return strText.substring(0, start) 
	            + sbMaskString.toString() 
	            + strText.substring(start + maskLength);
	    }
}