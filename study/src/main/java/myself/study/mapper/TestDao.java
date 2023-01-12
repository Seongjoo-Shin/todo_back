package myself.study.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import lombok.extern.slf4j.Slf4j;
import myself.study.model.TestDto;

@Repository
@Slf4j
public class TestDao {

	public static final String COLLECTION_NAME = "Test";

	public List<TestDto> getData() throws ExecutionException, InterruptedException {
		List<TestDto> list = new ArrayList<>();
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(TestDto.class));
        }
        return list;
	}
}
