/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokoKue.TokoKue;

import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Inspiron
 */
public class controller {
    tablecontroller result = new tablecontroller();
    @RequestMapping("/inputdata")
    
    public String getHasll(HttpServletRequest data, Model model) {
        String getNama = data.getParameter("Nama_Kue");
        int getJumlah = Integer.parseInt(data.getParameter("Jumlah_Kue"));
        int getHarga = Integer.parseInt(data.getParameter("Harga_Kue"));
        
        int diskon = result.getharga(getJumlah, getHarga);
        int compute = result.gethitung(getJumlah, getHarga);
        
        model.addAttribute("Nama",getNama);
        model.addAttribute("Barang", getJumlah);
        model.addAttribute("Harga", ("Rp. "+ getHarga));
        model.addAttribute("Total", ("Rp. "+(getHarga*getJumlah)));
        model.addAttribute("Diskon", "Rp. "+ compute);
        model.addAttribute("TotalDiskon", diskon + " %");
        
        return "tableviewer";
    }
}
