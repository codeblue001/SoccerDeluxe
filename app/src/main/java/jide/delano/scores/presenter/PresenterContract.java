package jide.delano.scores.presenter;

import java.util.List;

import jide.delano.scores.model.MatchResult;
import jide.delano.scores.view.ViewContract;

public interface PresenterContract {
    void initRetrofit();
    void onBindView(ViewContract view);
    void unBind();
    void onMatchResultDataSuccess(List<MatchResult> match);
    void onMatchResultDataFailure(String errorMessage);

}
