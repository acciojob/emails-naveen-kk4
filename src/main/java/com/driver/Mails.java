package com.driver;

import java.util.*;
import java.io.*;

public class Mails {

        private Date date;
        private String sender;
        private String message;

        public Mails(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public Date getDate() {
            return date;
        }
    }

