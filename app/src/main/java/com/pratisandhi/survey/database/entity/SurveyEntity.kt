package com.pratisandhi.survey.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SurveyEntity(
    val name: String,
    val email: String,
    val contactNo: String,
    val age: String,
    val city: String,
    val sex: String,
    val gender: String,
    val do_you_belong_to_a_Rural_or_an_Urban_setting: String,
    val marital_Relationship_Status: String,
    val at_what_age_did_you_first_engage_in_any_form_of_sexual_activity: String,
    val at_what_age_did_you_first_engage_in_sexual_intercourse: String,
    val how_often_do_you_engage_in_sexual_activity: String,
    val how_often_do_you_engage_in_sexual_intercourse: String,
    val what_are_your_primary_sources_of_information_on_sexual_health: String,
    val have_you_ever_consulted_a_doctor_for_any_sexual_health_concerns: String,
    val if_you_answered_yes_to_the_previous_question_were_you_able_to_get_an_adequate_solution_to_your_concern: String,
    val which_of_the_following_sexual_activities_have_you_engaged_in_during_the_past_two_years: String,
    val did_COVID_impact_your_sexual_life: String,
    val how_often_do_you_use_contraceptives: String,
    val which_of_the_following_contraceptives_are_you_familiar_with: String,
    val which_of_the_following_contraceptives_do_you_use_regularly: String,
    val do_you_think_that_the_current_awareness_levels_on_contraception_are_adequate: String,
    val have_you_ever_experienced_any_negative_side_effects_from_contraceptive_usage: String,
    val if_yes_what_side_effects_have_you_faced: String,
    val are_you_or_will_you_be_comfortable_buying_contraceptives: String,
    val which_of_the_following_emotions_do_you_identify_with_when_trying_to_purchase_contraceptives: String,
    val are_contraceptives_easily_available_near_your_area_of_residence: String,
    val what_are_some_challenges_you_face_when_trying_to_access_contraceptives: String,
    val where_will_be_the_most_comfortable_place_for_you_to_buy_contraceptives: String,
    val who_mostly_buys_the_contraceptive_that_you_or_your_partner_uses: String,
    val have_you_ever_felt_pressured_by_peers_or_your_partner_to_not_use_contraception_: String,
    val for_what_purpose_do_you_usually_use_condoms: String,
    val how_effective_are_condoms_in_preventing_pregnancy: String,
    val what_condom_brand_do_you_think_is_most_reliable: String,
    val have_you_ever_used_an_oral_emergency_pill: String,
    val for_what_reason_have_you_used_an_emergency_pill: String,
    val how_many_times_would_you_say_you_have_used_an_emergency_pill_in_the_past_three_years: String,
    val are_there_any_barriers_you_have_faced_in_using_emergency_pills_If_yes_what_are_they: String,
    val have_you_heard_about_sexually_transmitted_infections_such_as_HIV_AIDS_Chlamydia_Herpes_etc: String,
    val have_you_ever_had_a_STI_scare: String,
    val what_are_the_sources_you_rely_on_for_information_related_to_STIs: String,
    val have_you_ever_gotten_tested_for_STIs: String,
    val have_you_ever_faced_any_barriers_when_getting_tested_for_STIs_If_yes_what_are_theys44: String,
    val do_you_think_getting_tested_for_STIs_is_important: String,
    val do_you_think_it_is_important_to_get_tested_even_if_you_have_one_sexual_partner: String,
    val has_your_partner_ever_gotten_tested_for_STIs: String,
    val have_you_ever_had_a_conversation_with_your_partner_about_their_STI_status_before_engaging_in_sexual_activity: String,
    val if_you_have_multiple_sexual_partners_do_you_think_it_is_your_responsibility_to_get_tested: String,
    val do_you_think_it_is_only_your_responsibility_to_get_tested: String,
    val if_you_have_only_one_sexual_partner_who_would_you_prefer_gets_tested: String,
    val have_you_ever_consulted_a_doctor_or_a_medial_professional_to_get_an_opinion_related_to_stis: String,
    val what_do_you_think_is_the_best_place_for_you_to_get_tested_if_you_had_to: String,
    val condoms_are_the_only_contraceptive_which_protects_from_stis_arising_from_sexual_intercourse: String,

    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}