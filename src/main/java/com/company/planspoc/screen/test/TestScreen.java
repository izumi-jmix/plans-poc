package com.company.planspoc.screen.test;

import java.util.Collection;

import com.company.planspoc.entity.AnotherPerson;
import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.core.Id;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("TestScreen")
@UiDescriptor("test-screen.xml")
public class TestScreen extends Screen {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private EntityStates entityStates;

    @Subscribe
    public void onAfterShow(final AfterShowEvent event) {
        final Collection<AnotherPerson> persons = dataManager.load(AnotherPerson.class).all().list();
        if (persons.isEmpty()) {
            return;
        }

        final AnotherPerson notReloaded = persons.iterator().next();
        final AnotherPerson both = reloadBoth(notReloaded);
        final AnotherPerson specificWithCommonId = reloadSpecificWithCommonId(notReloaded);
        final AnotherPerson commonWithSpecificId = reloadCommonWithSpecificId(notReloaded);
        final AnotherPerson specificOnly = reloadSpecificOnly(notReloaded);
        final AnotherPerson commonOnly = reloadCommonOnly(notReloaded);
        final int debug = 4;
    }

    private AnotherPerson reloadBoth(AnotherPerson person) {
        return dataManager.load(Id.of(person))
                .fetchPlan(builder -> builder
                        .add("anotherGroups", gBuilder -> gBuilder
                                .add("another")
                        )
                        .add("group", gBuilder -> gBuilder
                                .add("id")
                                .add("size")
                        )
                        .add("lastName")
                )
                .one();
    }

    private AnotherPerson reloadSpecificOnly(AnotherPerson person) {
        return dataManager.load(Id.of(person))
                .fetchPlan(builder -> builder
                        .add("anotherGroups", gBuilder -> gBuilder
                                .add("another")
                        )
                        .add("lastName")
                )
                .one();
    }

    private AnotherPerson reloadCommonOnly(AnotherPerson person) {
        return dataManager.load(Id.of(person))
                .fetchPlan(builder -> builder
                        .add("group", gBuilder -> gBuilder
                                .add("id")
                                .add("size")
                        )
                        .add("lastName")
                )
                .one();
    }

    private AnotherPerson reloadSpecificWithCommonId(AnotherPerson person) {
        return dataManager.load(Id.of(person))
                .fetchPlan(builder -> builder
                        .add("anotherGroups", gBuilder -> gBuilder
                                .add("another")
                        )
                        .add("group", gBuilder -> gBuilder.add("id"))
                        .add("lastName")
                )
                .one();
    }

    private AnotherPerson reloadCommonWithSpecificId(AnotherPerson person) {
        return dataManager.load(Id.of(person))
                .fetchPlan(builder -> builder
                        .add("anotherGroups", gBuilder -> gBuilder.add("id"))
                        .add("group", gBuilder -> gBuilder
                                .add("id")
                                .add("size")
                        )
                        .add("lastName")
                )
                .one();
    }
}