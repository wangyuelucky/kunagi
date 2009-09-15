package scrum.client.risks;

import scrum.client.ScrumGwtApplication;
import scrum.client.workspace.Ui;

public class CreateRiskAction extends GCreateRiskAction {

	@Override
	public String getLabel() {
		return "Create new Risk";
	}

	@Override
	public boolean isExecutable() {
		return true;
	}

	@Override
	protected void onExecute() {
		Risk risk = ScrumGwtApplication.get().getProject().createNewRisk();
		Ui.get().showRiskList(risk);
	}

}
