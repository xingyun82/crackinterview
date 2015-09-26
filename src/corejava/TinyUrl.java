package corejava;

import java.util.*;
import java.security.*;

/**
 * design a tiny url system
 *
 * architect:
 * 0. load balance
 * 1. service layer
 * 2. cache layer (consistent hash)
 * 3. persistence layer (sharding, replication(master-slave))
 *
 * algorithm:
 * hash: longurl -> shorturl
 * hash = base62(md5(longurl+random))[:k]
 *
 * Created by xingyun on 9/24/15.
 */
public class TinyUrl {



    public String tintyUrl(String longUrl, int k) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] res = digest.digest(longUrl.getBytes());
            StringBuffer sb = new StringBuffer();
//            for(byte b:res) {
//                b & 0xff ;
//            }
        } catch(Exception e) {

        }
        return null;
    }
}
