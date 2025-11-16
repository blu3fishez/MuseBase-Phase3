package knu.database.musebase.data;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Song {
    private long id;
    private String title;
    private long length;
    private String playLink;
    private Timestamp createAt;
    private long providerId;
}
