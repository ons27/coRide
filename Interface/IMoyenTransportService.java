/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entities.MoyenTransport;
import java.util.List;

/**
 *
 * @author TECHN
 */
public interface IMoyenTransportService<MoyenTransport> {
   
    public void ajouterMoyenTransport(MoyenTransport m);
    public void supprimerMoyenTransport(MoyenTransport m);
    /**
     *
     * @param m
     */
    public void modifierMoyenTransport(MoyenTransport m);
    public List<MoyenTransport> afficherMoyenTransports();
    
}
