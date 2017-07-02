package com.ytmanager;

import org.apache.catalina.*;
import org.apache.catalina.Store;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiachen215 on 2017/6/9.
 */
public interface PurchaseRepository extends CrudRepository<Purchase,Long> {}
