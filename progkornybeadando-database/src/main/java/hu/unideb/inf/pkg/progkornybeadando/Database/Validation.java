package hu.unideb.inf.pkg.progkornybeadando.Database;


import static hu.unideb.inf.pkg.progkornybeadando.Database.Database.konkatenalXML;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;
import static hu.unideb.inf.pkg.progkornybeadando.Database.TempXML.adat;
/**
 *
 * @author Juhász Gyula
 */
public class Validation {
    private  TempXML xml=TempXML.getxml();
    List<String> felhasznalo_nevek=new ArrayList<>();
    List<String> jelszavak=new ArrayList();
    List<String> user_nevek=new ArrayList();
    public static loginUser logadatok;

    private Validation() {
    }
    private static Validation peldany;
    
    public static Validation getPeldany()
    {
        if(peldany == null)
            peldany = new Validation();
        return peldany;
    }
    
    public static Validation peldanyka= Validation.getPeldany();
    
    public void setLogadatok(loginUser logadatok) {
        this.logadatok = logadatok;
    }
    
    public boolean hibaVan2=false;

    public boolean isHibaVan2() {
        return hibaVan2;
    }

    public void setHibaVan2(boolean hibaVan2) {
        this.hibaVan2 = hibaVan2;
    }
    
    public void valid_reg(NodeList n1){       
        for(int i = 0; i< n1.getLength();i++){
            String felhasznalo_id = n1.item(i).getAttributes().getNamedItem("id").getNodeValue();
            felhasznalo_nevek.add(felhasznalo_id);
            if(felhasznalo_nevek.get(i).equals(adat.getUserfield())){
                xml.setHibaVan(true);
            }
        }
        if(adat.getUserfield().length()<5 || adat.getPasswordfield().length()<5 ){
            xml.setHibaVan(true);
        }else{
            if(adat.getPasswordfield().equals(adat.getPasswordfield2()) && xml.isHibaVan()==false){
                xml.tempXML();
                konkatenalXML();
            }else{
                xml.setHibaVan(true);
            }
        }
    }
    public void valid_log(NodeList n1,NodeList n2){
            for(int i = 0; i< n1.getLength();i++){
            jelszavak.add(n1.item(i).getTextContent());
            String fel_id = n2.item(i).getAttributes().getNamedItem("id").getNodeValue();
            user_nevek.add(fel_id);
            if(user_nevek.get(i).equals(logadatok.getLogUser()) && jelszavak.get(i).equals(logadatok.getLogPassword())){
                hibaVan2=false;            
                break;
            }else{
                hibaVan2=true;
            }
          
        }
    }
      
}
