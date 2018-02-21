/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author adriano
 */
public class ListVirtualScrenning {
    private static final List<VirtualScrenning> virtualScrenningList = new ArrayList();
    
    private ListVirtualScrenning(){
        
    }
    public static List <VirtualScrenning> getInstance(){
        return virtualScrenningList;
    }
    
    public static void addVirtualScrenning(VirtualScrenning virtualScrenning){
        removeVirtualScrenning(virtualScrenning.getID());
        virtualScrenningList.add(virtualScrenning);
    }
    
    public static VirtualScrenning getVirtualScrenning(String id){
        for (Iterator<VirtualScrenning> iterator = virtualScrenningList.iterator(); iterator.hasNext();) {
            VirtualScrenning next = iterator.next();
            if(next.getID().equals(id)){
                return next;
            }
        }
        return null;
    }
    public static void removeVirtualScrenning(String id){
        int index = 0;
        for (Iterator<VirtualScrenning> iterator = virtualScrenningList.iterator(); iterator.hasNext();) {
            VirtualScrenning next = iterator.next();
            if(next.getID().equals(id)){
                virtualScrenningList.remove(index);
                break;
            }
            index++;
        }
    }
}
