package myself.study.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import myself.study.model.TodoDto;

@Repository
public class TodoDao {

	public static final String COLLECTION_NAME = "Test";
	public static final String CAPTION = "TODO";

	public List<TodoDto> getData() throws ExecutionException, InterruptedException {
		List<TodoDto> list = new ArrayList<>();
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            list.add(document.toObject(TodoDto.class));
        }
        return list;
	}

	public int insertData(TodoDto dto) {
		Firestore db = FirestoreClient.getFirestore();
		TodoDto todoDto = new TodoDto();

		todoDto.setTodoContent(dto.getTodoContent());
		todoDto.setTodoChecked(false);
		todoDto.setTodoDeleted(false);
		todoDto.setTodoDate(new Date());

		ApiFuture<WriteResult> apiFuture = db.collection(COLLECTION_NAME).document().set(todoDto);

		return 0;
	}
}
