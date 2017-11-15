package com.nolanroe.magicscoreboard;

/**
 * Created by Danolanater on 10/9/2017.
 */

public class MatchHistory  {

    public String getmOpponentName() {
        return mOpponentName;
    }

    public String getmGameType() {
        return mGameType;
    }

    public String getmMatchScore() {
        return mMatchScore;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmResult() { return mResult;}

    private String mOpponentName;
    private String mGameType;
    private String mMatchScore;
    private String mDate;
    private String mResult;

    public MatchHistory(String opponentName, String gameType, String matchScore, String date, String result) {
        mOpponentName = opponentName;
        mGameType = gameType;
        mResult = result;
        mDate = date;
        mMatchScore = matchScore;
    }



//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.match_history_list);
//        myDb = new DatabaseHelper(this);
//
//        // viewAll();
//    }

//    public void viewAll() {
//        Cursor res = myDb.getAllData();
//        if(res.getCount() == 0) {
//            showMessage("Error", "No data found");
//            return;
//        }
//        StringBuffer buffer = new StringBuffer();
//        while (res.moveToNext()) {
//            buffer.append("Id :" + res.getString(0) + "\n");
//            buffer.append("Opponent :" + res.getString(1) + "\n");
//            buffer.append("Match Type :" + res.getString(2) + "\n");
//            buffer.append("Result :" + res.getString(3) + "\n\n");
//        }
//
//        showMessage("Data",buffer.toString());
//    }
//
//    public void showMessage(String title, String message) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.show();
//    }
}

