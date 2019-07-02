/**
 * 
 */
package com.socket.rootchat;

/**
 * @author PE
 * @date 2019年6月28日 下午3:40:06
 * @explain 
 create table dictionary(
   id int AUTO_INCREMENT,
   receive varchar(100),
   response varchar(100),
   PRIMARY KEY (id)
)  DEFAULT CHARSET=utf8;
 
insert into dictionary values(null,'你好','好你妹！');
insert into dictionary values(null,'你叫什么','你想泡我啊？');
insert into dictionary values(null,'你叫什么','同志，不约');
insert into dictionary values(null,'打你哦','来啊，来打我啊，不打有点挫');
 */
public class Dictionary {
    int id;
    String receive ;
    String response;
}
