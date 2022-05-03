package com.example.bica.EntireCard;

import android.app.Application;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.bica.model.Card;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class CardModel {

    private Application application;

    // Firebase
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;

    // Values
    private ArrayList<Card> arrCard;
    private MutableLiveData<ArrayList<Card>> cardMutableLiveData;

    public CardModel(Application application) {
        this.application = application;

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        arrCard = new ArrayList<>();
        cardMutableLiveData = new MutableLiveData<>();
    }

    public void entireCard() {
        firestore.collection("users").document(auth.getCurrentUser().getUid())
                .collection("myCard").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                for (DocumentChange dc : value.getDocumentChanges()) {
                    switch (dc.getType()) {
                        case ADDED:
                            Card card = dc.getDocument().toObject(Card.class);
                            arrCard.add(card);
                            cardMutableLiveData.postValue(arrCard);
                            break;

                        case MODIFIED:
//                            arrCard.remove(dc.getOldIndex());
//                            card = dc.getDocument().toObject(Card.class);
//                            arrCard.add(card);
                            break;

                        case REMOVED:
                            break;

                        default:
                            break;
                    }

                }
            }
        });
    }

    public LiveData<ArrayList<Card>> getCardLiveData() {
        return cardMutableLiveData;
    }
}