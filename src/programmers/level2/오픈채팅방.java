package programmers.level2;

import java.util.*;

public class 오픈채팅방 {

    public String[] solution(String[] record) {
        //uid, 닉네임 해시맵

        //입장할 때 맵에 저장
        //uid 변경 시 닉네임 변경

        //리스트에 메시지 저장
        //메시지 클래스 : uid, 들어오고 나간 여부
        //들어오거나 나갔을 때 메시지 저장

        Map<String, String> users = new HashMap<>();
        List<Message> messages = new ArrayList<>();

        for(String r : record) {
            String[] arr = r.split(" ");

            if(arr[0].equals("Enter")) {
                users.put(arr[1], arr[2]);
                messages.add(new Message(arr[1], true));
            }
            else if(arr[0].equals("Leave")) {
                messages.add(new Message(arr[1], false));
            }
            else {
                users.put(arr[1], arr[2]);
            }
        }

        String[] answer = new String[messages.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = messages.get(i).toString(users);
        }

        return answer;
    }

    class Message {
        String uid;
        boolean in;

        public Message(String uid, boolean in) {
            this.uid = uid;
            this.in = in;
        }

        public String toString(Map<String, String> users) {
            if(in)
                return users.get(uid) + "님이 들어왔습니다.";
            else
                return users.get(uid) + "님이 나갔습니다.";
        }
    }
}
