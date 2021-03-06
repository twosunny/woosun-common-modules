package woosun.common.encrypt.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import woosun.common.convert.service.ObjectConvertService;
import woosun.common.utils.EncryptUtils;

@Component
public class EncryptComponent {
	
	@Autowired
	private EncryptServiceStore encryptServiceStore;
	
	@Autowired
	private ObjectConvertService objectConvertService;

	public String textEncrypt(String storeName, String inputStr){
		
		String enc = null;
		
		try{
			enc = 
			encryptServiceStore.getEncryptService(storeName).textEncrypt(inputStr);
			
		}catch(Exception e){
			return enc;
		}
		
		return enc;
	}
	
	public String textDecrypt(String storeName, String inputStr){
		
		String dec = null;
		
		try{
			dec = 
			encryptServiceStore.getEncryptService(storeName).textDecrypt(inputStr);
			
		}catch(Exception e){
			return dec;
		}
		
		return dec;
	}
	
	
	public String getMd5Hash(Object obj) {
		String json = objectConvertService.objectToJson(obj);
		return EncryptUtils.getMd5Hash(json);
	}

	
	public String getSha256Hash(Object obj) {
		String json = objectConvertService.objectToJson(obj);
		return EncryptUtils.getSha256Hash(json);
	}
}
