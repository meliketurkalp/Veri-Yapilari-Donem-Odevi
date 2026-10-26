package tr.edu.inonubm.studyapp.deneme;

import java.time.LocalDate;
import tr.edu.inonubm.studyapp.model.CalismaPlani;

public class AramaDenemesi {

	public static void main(String[] args) {
		LocalDate tarih = LocalDate.of(2026, 10, 26);

		CalismaPlani[] planlar = {
				new CalismaPlani(1,1,"Veri Yapilari","Bagli Liste",60, tarih,"Ilk Ornek"),
				new CalismaPlani(2,1,"Veri Yapilari","Agac",45, tarih,"Ikinci Ornek"),
		};

		int arananPlanId = 2;
		CalismaPlani bulunanPlan = null;

		for (CalismaPlani plan : planlar) {
			if(plan.getPlanId() == arananPlanId) {
				bulunanPlan = plan;
				break;
			}
		}

		if (bulunanPlan != null) {
			System.out.println("Bulunan plan: " + bulunanPlan);
		} else {
			System.out.println("Plan bulunamadi.");
		}

	}

}
