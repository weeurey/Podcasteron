package com.liamure.podcasteron.podcasteron;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RadioActivity extends AppCompatActivity {


    //Sets up the vars for the download process

    ProgressDialog mProgressDialog;
    String downloadName;

    //Sets up vars used for the User Interface

    int currentScroll;
    ScrollView scrollview;
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    View cusView;
    TextView selectLbl;
    Button selectBtn;
    TextView textViewDescTitle;
    TextView textViewDesc;
    TextView textViewDescDate;
    String episodeRequested;


    //Sets up the vars used for the episode description interface

    RelativeLayout DescLayout;
    GridLayout episodeGrid;
    SQLiteDatabase eventsDB;


    public void createDB(){
//This method creates and populates the database primarily used for the description layouts
        //I would have liked to have all the database code in its own class file but I was having trouble setting it up

        try {

            Log.i("radioResults - descr","Created DB");



            eventsDB.execSQL("CREATE TABLE IF NOT EXISTS desc (episode VARCHAR, date VARCHAR, descr VARCHAR)");
            eventsDB.execSQL("DELETE FROM desc");

//            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-1', '', '')");

            //                              RADIO 1 Inserts data into the DB
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-1', '10 November 2001', 'This show is the earliest known recording of Ricky Gervais and Stephen Merchant on Xfm following their return to the station after the Capital Group takeover.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-2', '17 November 2001', 'Steves animal trivia about birds with penises leads to an afternoon of euphemisms and double entendres, much to Karls chagrin.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-3', '24 November 2001', 'Its Stephen Merchants birthday. Both he and Ricky are hung over after going out (separately) the previous night.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-4', '24 November 2001', 'Karl: Well...like, when youre born, youre a little baby, youre wrinkly and stuff, when you get older you sort of morph into a baby again.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-5', '08 December 2001', 'Karl talks about his mobile disco.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-6', '15 December 2001', 'Features Rickys song Dont cry, its Christmas - also, Jonathan Ross stops by and whips out his famous member. Karl wants to know what gem the Pope wears, but then he loses the printoff and cant answer.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-7', '22 December 2001', 'Ricky and Steve discuss Christmas presents and the Bionic Man.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-8', '12 January 2002', 'Steve discusses the drawbacks of being 6´ 7´´ tall, and Karl reveals the origin of baguettes.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-9', '19 January 2002', 'Steve and Ricky talk about driving incidents. Karl tells a story about ghosts he heard from a program called Mr. Exorcist involving a depressed budgie. Ricky invites the listeners to send in their questions for Karl.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-10', '26 January 2002', 'Karl informs Ricky and Steve how much it costs to run the Tube escalators 20 hours a day.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-11', '09 February 2002', 'Steve complains about people talking on phones in cinemas, but Karl gets the better of him.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-12', '16 February 2002', 'Ricky talks about feng shui and tries to get Karl to say one of the gods (FUK)')");
           // eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-', '', '')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-13', '23 February 2002', 'Karl reveals he never went to receive his GCSE results')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-14', '02 March 2002', 'Karl receives his GCSE result, and talks about this classmates from school including his pet, Maggie the magpie.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-15', '09 March 2002', 'Karls homework: read all about Che Guevara; White Van Karl; Karls brother; Karl in Little Donkey; Elephant woman.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-16', '16 March 2002', 'Karl in Heat; Karls homework: Hitler; White Van Karl: Will Young, police protest, privacy laws; Attaching 6000 balloons to Karl.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-17', '23 March 2002', 'Ricky wants to have Karl lifted up in the air by balloons. Ricky teaches Karl about fables.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-18', '30 March 2002', 'Karls homework: Aesops Fables. Ricky in trouble for coarse sexual innuendo.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-19', '06 April 2002', 'Episode with the now famous, or infamous, White Van Karl links containing the Horse in the House story, Karl selling little snippings of flowers for charity, and the Sainsbury tins thatll be interesting for Meatballs finalé.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-20', '13 April 2002', 'Karls dad puts a Forrest Gump In A Wheelie Bin.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-21', '20 April 2002', 'Karl does impressions; Karl beats Ricky at lateral puzzles and goes a bit mental over it.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-22', '27 April 2002', 'The boys return from the BAFTAs; they talk about urban myths.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-1-Episode-23', '04 May 2002', 'Last episode in the series. Karls Room 101')");



            //                              RADIO 2
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-1', '24 August 2002', 'Ricky, Steve and Karl compare their individual journeys back from the Edinburgh Festival, and Karl mishears mammoth as man moth.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-2', '31 August 2002', 'Ricky and Steve interview Karl to re-introduce him to the listening public. Karl starts a competition he calls Whats The Song?, that in later shows becomes Rockbusters.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-3', '07 September 2002', 'Karl gets annoyed that Ricky cant record links for next weeks Best Of show because he must leave immediately after the show to go on holiday.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-4', '14 September 2002', 'With Ricky on holiday in Italy (see 07 September 2002), Karl is left introducing this Best of compilation (aka Best Of #1). Karl introduces all the links (Rickys on holiday...and Steve cant be bothered)')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-5', '21 September 2002', 'Karls 30th birthday on Monday leads him to think about the best thing hes ever done.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-6', '28 September 2002', 'Claire Sturgess stands in for Karl, as his girlfriend Suzanne has taken him to the Canary Islands for his birthday.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-7', '05 October 2002', 'Karl is away for another week as when he was on holiday his dad was admitted to hospital and he had to help with things.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-8', '12 October 2002', 'Karl introduces the new feature Educating Ricky and its the very first week of Rockbusters. Karl also suggestions for radio quizzes including Strike it Rick and Big Mother (in which listeners would win a CD if they had a heavy mother).')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-9', '19 October 2002', 'Rickys got a hangover, and the second week of Rockbusters.Karl wants to be Frog boy. Educating Ricky has its second installment.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-10', '26 October 2002', 'Steve wants tickets for Bruce Springsteen. Karl explains how to escape from anacondas. Educating Ricky has its third installment. Karl gets all three educating stories in back-to-back.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-11', '02 November 2002', 'Karl trys to sell his futon and desk combo for £100 and has a small laughing fit during Rockbusters. Educating Ricky is back for its fourth installment.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-12', '09 November 2002', 'Karl gets called a dickhead by a tramp and talks about cheating church. Ricky talks about his boxing. Educating Ricky has its fifth installment. Karls now-famous utterances I typed why into the search engine to try and confuse the computer along with you never see an old man avin a Twix are in THIS show.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-13', '16 November 2002', 'Ricky and Steve discuss Karl being labelled a genius in Heat Magazine. Rockbusters goes down a storm, and we get the 6th installment (the longest thus far at about 22 minutes total) of Educating Ricky.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-14', '23 November 2002', 'MTV have offered Karl the opportunity to record a screen test but hes reluctant. Karl interviews a woman who claims to have a ghost living in her house in a feature called Pilkington. Educating Ricky episode 7 is also featured.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-15', '30 November 2002', 'Xfm have started an advertising campaign for the show but Karl didnt want to be inclduded. Ricky explains how Jonathan Ross sees him as a predatory gay. Educating Ricky Episode 8 completes the show.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-16', '07 December 2002', 'Karl records his screen test for MTV today. Ricky and Steve demonstrate how gullible Karl is when reading internet material.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-17', '14 December 2002', 'Claire Sturgess is sitting in for Karl and talks with Ricky and Steve about The Fight.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-18', '21 December 2002', 'Karls not buying his girlfriend Suzanne anything for Christmas because hes taking her out for dinner.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-19', '28 December 2002', 'A Best of compilation show. aka Best of #2')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-20', '04 January 2003', 'Ricky and Steve are astounded to learn that Karl bought his girlfriend an industrial-sized box of condoms for Christmas.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-21', '11 January 2003', 'Stephen has overheard some people slagging off Ricky in public, and Karl believes in ghosts of women seeing ghosts of themselves.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-22', '18 January 2003', 'Ricky investigates the effects of blunt objects on the skull, Stephens feelings are hurt and Karl explores his sexuality.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-23', '25 January 2003', 'The now-famous (or infamous, as the case may be) Monkey News makes its debut. Ricky performs the jingle for the first time in the feature originally called Chimpanzee That!')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-24', '01 February 2003', 'Karl slags off clairvoyants, Ricky slags off God and Stephen slags off Karl (then punches him in the arm). The debut of Karl in a Film.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-25', '08 February 2003', 'Karl gets excited about conjoined twins but less enthused about the literary implications of infinite monkeys.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-26', '15 February 2003', 'Ricky is so disgusted with the show that he finally says, thats it, were taking two weeks off. No show for two weeks or something to that effect.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-27', '22 February 2003', 'A Best of compilation. aka Best of #3. Ricky and Steve pre-record their intros to all the links.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-28', '01 March 2003', 'Another Best of compilation. aka Best of #4. Ricky and Steve pre-record their intros to all the links.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-29', '08 March 2003', 'Claire Sturgess stands in for a sick Karl. Ricky and Steve start giving out digits of Karls phone number, and eventually manage to get him on the phone.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-30', '15 March 2003', 'Karls been off ill - much to Rickys disgust - a new feature is born and tension between Karl and Stephen comes to a head.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-31', '22 March 2003', 'Karl is disappointed by the film Freaks, confused by transsexuals and slapped in the head live on-air by Stephen.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-32', '29 March 2003', 'Ricky and Stephen are adamant that Karl should appear on the shows poster and more interest groups are offended.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-33', '05 April 2003', 'Steve runs to the local McDonalds to fetch 5 hamburgers for Karl to stuff in his mouth in an attempt to break a world record. After failing miserably at that, Karl eats 62 grapes in three minutes; 71 shy of the record. Karls explanation is that he has a small throat.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-34', '12 April 2003', 'Ricky, Karl and Steve break the law on-air for the first time as Karl gets curious about the extent of Derren Browns powers.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-34', '12 April 2003', 'Ricky, Karl and Steve break the law on-air for the first time as Karl gets curious about the extent of Derren Browns powers.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-35', '19 April 2003', 'Claire Sturgess fills in for Karl, who is in Madeira with Suzanne and her parents. The boys suffer from hypochondria; Ricky wears a white suit to the BAFTAs; Steve fancies Louise Woodward; reality shows; the Innovations Catalogue; Call your friends and tell them its a girl; Karl is deemed superfluous.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-36', '26 April 2003', 'Karl is back, bringing Rockbusters with him, and Ricky invents some new characters to liven up the show.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-37', '03 May 2003', 'Its the Sonys this week, so make it a good one. Rockbusters today. Karl got a message from someone wanting Steve to do voiceover work--money for old rope--but didnt pass it on to Steve until a week later.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-38', '10 May 2003', 'Vowing to improve the show after last weeks Sony failure, Ricky consults Dr. Fox and attempts to interact with the listeners.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-39', '17 May 2003', 'Ricky has done his back in wrestling. Rockbusters contest today. Cheeky Freak of the Week--Lobsterman and the Siamese twins who got run over why didnt he just look both ways? Monkey News--chimp number 86, the magicians assistant hopped in the car at the gas station and drove to Spain. Of course it was possible--the car was an automatic.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-40', '31 May 2003', 'Springsteen has an armpit fetish? Hankies in back pockets, Karl has the research. Karl wont leave the hotel room in Tenerife due to his state of arousal, discussion about dying, cloning, and ones last day on earth, the weekly episodes of Blockbusters, CFOTW (Cheeky Freak of the Week), and Monkey News--with two monkey stories this week--BONUS.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-41', '07 June 2003', 'Karl going on Holiday to Cornwall this coming week---anxious about going to Monkey World--twice. Bauhaus is not working, Bauhaus is not working!! Ricky loses 400 quid out of his suit pocket, Steve recounts story at University about finding a cashpoint card in the machine, and rewarding himself 30 quid (Karl would have taken 20), the great flower/greeting card company conspiracies, warnings on fag packets, the boneless person, Monkey News (homeless chimp in Russia), Rockbusters, and CFOTW live on, Karl leaves early to catch the train.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-42', '14 June 2003', 'Karls holiday in Cornwall recap; Rockbusters and Monkey News now ended according to Ricky, but they do come back anyway; Monkey News from Karls Dad and a Monkey News Extra (Monkey Business)')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-43', '21 June 2003', 'Medical, zoo, charity, and taxi drivers talk. Shaving ones arse, feeling testicles, owl on a desk, Maggie the Magpie, do you know the way to Camden? Monkey News (bequeathing the monkey spa to the kids) and Rockbusters still alive but on very thin ice.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-44', '28 June 2003', 'Steves great New Years party in Bristol: Its just that...weve arranged to meet back at you. Plus Monkey News (chimps joining the army and doing the obstacle course?), Educating Ricky, Rockbusters, Auntie Nora, an that.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-45', '05 July 2003', 'Ricky and Steve pre-record a spot lampooning the Radio Authority, but the Managing Director of XFM bins that. Karl has to go along with the decision, even with the swearing bleeped out. Karl getting ready to go on holiday again. This time, its Hastings. No more cheeky freak of the week is this weeks Songs of Phrase. Monkey News--monkey prison in India. The boys have stories of winding teachers up in school.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-46', '12 July 2003', 'Karls kitchen re-doing, Steves big feet. Songs of Phrase. Karl and babies. Steves big TV. Wheelchair tennis and the Paralympics. Karl gets a kiss from Steve on the head. Karl recaps holiday in Hastings and specialty shops. Answers to Songs of Phrase and Monkey news--the chimp that won the 400 meter race in the 1908 London Olympics an that.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-47', '19 July 2003', 'People you hate, What do you like. The chinese language. Scruting the china-woman. Anteaters and the wax museum. Songs of phrase. KP looks after me. If Karl were PM or President. Winner of who is the most hated among the listeners. Monkey News--the chimp cyclist, on the tricycle, in the London-Brighton bike ride.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-48', '26 July 2003', 'People you hate, What do you like. The chinese language. Scruting the china-woman. Anteaters and the wax museum. Songs of phrase. KP looks after me. If Karl were PM or President. Winner of who is the most hated among the listeners. Monkey News--the chimp cyclist, on the tricycle, in the London-Brighton bike ride.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-49', '02 August 2003', 'Bondage shop--Open. Cock soup and hermaphrodites. Lots of knob news (including theatrical castration, Hitlers penis and genital torture devices). Songs of Phrase; I know youre just 16 but looking all of 21, thats because Chinese look older. Calling Moyles with golf songs. Educating Karl. Big eyelids. Freaks. Homeless & St. Johns Ambulance people. Monkey news--monkey astronaut made a NASA trainer, then a colonel, got a pension, an that.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-50', '09 August 2003', 'Handling the heat wave. Nudist chat. frontal shots of sprinters, Monkey news--chimp prostitute. Karl laughs on air.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-2-Episode-51', '16 August 2003', 'Last show of the series. Ricky and Steve filming The Office Specials in the interim. Will they return? More charity talk. Newton and Einstein. The Daily Telegraph is listening today! Monkey News extra -- Costa Rican monkey goalkeeper has a PhD in Physics.')");



            //                              RADIO 3

            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-1', '01 November 2003\t', 'After saying hed never do another show again, Karl is back just 3 months later - only now, hes got Mondays off.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-2', '08 November 2003\t', 'Karl is in trouble with Suzanne after saying, on last weeks show, that her new haircut made her look like Dave Hill from Slade.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-3', '15 November 2003\t', 'Suzannes big arse. Pop culture survey on VH1-rubbish. Jonathan Ross gave Ricky a cat, Steves insanely jealous of them being mates. Posters of Ricky and Steve on the Tube are to Steves embarrassment. Karl gets handed a card in Soho with the phrase \"The best bum in W-1\" on it. Karl getting involved with the police, being in Witness Protection from mafia.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-4', '22 November 2003\t', 'England wins 2003 rugby World Cup. Steve reminisces about his glasses. Karl and Steve trade insults about their appearances. The Office headed to America. Whats a proctologist?')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-5', '29 November 2003\t', 'Buttplugs. Karl goes on a blind date and is annoyed that he spent money on someone who is just going to die on him.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-6', '06 December 2003\t', 'Mobile discos of Karl and Steve. A program called Bodysnatchers was on during the week about parasites in the animal kingdom. Man with ear-problem accidentally has testicles removed. Half man, half biscuit.The war in the news. Elephant polo. Nelsons letters. Ricky - good neighbour, bad friend. Art - Lowry vs Dwarf in a box. Dog that does Nazi salute. German women.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-7', '13 December 2003\t', 'Xfms Christmas presents to the guys. Karl not buying for Suzanne. The birds and the bees. Baby wot giv birf to a baby. Rockbusters revisited. Lord of the Rings is shit. Nerdlingers. The English language. Karl in Films this week is Scrooge. Cheeky Freak of the Year: the 7 year old who is 38. Monkey News this week is about an aeroplane passenger complaining that they have no nuts.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-8', '20 December 2003\t', 'Karl is on holiday in Lanzagrotty, so Ricky and Steve are joined by Xfm DJ Ian Camfield.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-9', '27 December 2003\t', 'A Best of compilation.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-10', '03 January 2004\t', 'Karl cant get the original album version of Love Will Tear Us Apart. Hes back from his visit from Lanzagrotty and decides its made up of 36 volcanoes that should be filled in with cement. Karl finally reads The Guvna which is actually in order this time. The gang wonder how barometers work and comment on the rather nervous looking daughter on the cover of the calendar. Finally, theyre also clueless on China.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-11', '10 January 2004\t', 'The gang are back and theyre talking about the mysteries of the universe. Steve talks about how crap James Bond is. Karl talks about elephants with wooden teeth and Kirsty the lab assistants follies.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-3-Episode-12', '17 January 2004\t', 'Karl screams as Steve holds him down and Ricky rubs his nipple against Karls lips in an attempt to have Karl kiss it.')");

            //                              RADIO 4

            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-4-Episode-1', '28 May 2005', 'The show returns, Ricky and Stephen are standing in for Adam and Joe. They comment about how nothing has changed, except that the listenership has gone down possibly because each year a few old XFM listeners die, of smack addictions or gout. Ricky unveils some genuinely exciting prizes for Rockbusters, Karl talks about his testicles then gets a champagne cork shot at his head.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-4-Episode-2', '04 June 2005', 'Ricky dedicates the show to a group of scientists working in the Antarctic and Karl doesnt want anyone to put their finger up his arse.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-4-Episode-3', '11 June 2005', 'Ricky takes Karl on a day out to a golf course. Ricky intercepts fool-proof cooking instructions from Karls girlfriend, Suzanne, and Karl reminisces about the day he tried to put sausages in a toaster.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-4-Episode-4', '18 June 2005', 'Karl makes a new friend on the train from Manchester to London and takes issue with The Whos classic Pinball Wizard. Also on This Week: A sceptical journalist is convinced Karl is a creation of Ricky and Stephen, plus: Karl gets in trouble with his family and knobnews returns.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-4-Episode-5', '25 June 2005', 'This Week: Karl explains to Ricky and Stephen why Eric Claptons Wonderful Tonight is about a man in a wheelchair, and compares colonic irrigation to the Generation Game.')");
            eventsDB.execSQL("INSERT INTO desc (episode, date, descr) VALUES ('Radio-4-Episode-6', '02 July 2005', 'Steve talks about his trying experience when DJing at a wedding. Karl is annoyed because Ricky has to rush off to introduce R.E.M. at Live 8.')");






//WHERE episode = 'Season-2-Episode-1'

            //Test of the DB. Logs info to the IDE
            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode = 'Radio-1-Episode-1'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");


            c.moveToFirst();

            //Test of the DB. Logs info to the IDE


            while (c != null) {

                Log.i("rrrResults - episode", c.getString(episodeIndex));
                Log.i("Results - date", c.getString(dateIndex));
                Log.i("Results - descr", c.getString(descIndex));


                c.moveToNext();
            }


        }
        catch (Exception e) {

            e.printStackTrace();

        }




    }





    public void showMediaData(View view){

        //Set up vars and objects for description layout

        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayout);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodes) ;
        textViewDesc = (TextView)findViewById(R.id.txtDesc);
        textViewDescDate = (TextView)findViewById(R.id.txtDate);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitle);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();
        scrollview = (ScrollView)findViewById(R.id.r1Scroll);
        currentScroll = scrollview.getScrollY();

        //Return to top of scrollview
        scrollview.scrollTo(0, scrollview.getTop());


        //try find the data for the episode from the database
        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                //Set up the UI with the data gatherd from the DB
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //Start up a webview to that will load a webpage to allow users to leave comments
        WebView webView = (WebView) findViewById(R.id.webView6);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void showMediaDataR2(View view){

        //This method is currently almost identical to showMediaData()

        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutR2);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesR2) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescR2);
        textViewDescDate = (TextView)findViewById(R.id.txtDateR2);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleR2);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        scrollview = (ScrollView)findViewById(R.id.r2Scroll);
        currentScroll = scrollview.getScrollY();



        scrollview.scrollTo(0, scrollview.getTop());



        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        WebView webView = (WebView) findViewById(R.id.webView7);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }

    public void showMediaDataR3(View view){

        //This method is currently almost identical to showMediaData()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutR3);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesR3) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescR3);
        textViewDescDate = (TextView)findViewById(R.id.txtDateR3);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleR3);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        scrollview = (ScrollView)findViewById(R.id.r3Scroll);
        currentScroll = scrollview.getScrollY();



        scrollview.scrollTo(0, scrollview.getTop());



        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        WebView webView = (WebView) findViewById(R.id.webView8);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }


    public void showMediaDataR4(View view){

        //This method is currently almost identical to showMediaData()


        DescLayout = (RelativeLayout)findViewById(R.id.relDescriptionLayoutR4);
        episodeGrid = (GridLayout)findViewById(R.id.gridEpisodesR4) ;
        textViewDesc = (TextView)findViewById(R.id.txtDescR4);
        textViewDescDate = (TextView)findViewById(R.id.txtDateR4);
        textViewDescTitle = (TextView)findViewById(R.id.txtTitleR4);
        episodeGrid.setVisibility(View.INVISIBLE);
        DescLayout.setVisibility(View.VISIBLE);
        episodeRequested = view.getTag().toString();

        scrollview = (ScrollView)findViewById(R.id.r4Scroll);
        currentScroll = scrollview.getScrollY();



        scrollview.scrollTo(0, scrollview.getTop());



        try {

            Cursor c = eventsDB.rawQuery("SELECT * FROM desc WHERE episode='" + episodeRequested + "'", null);

            int episodeIndex = c.getColumnIndex("episode");
            int dateIndex = c.getColumnIndex("date");
            int descIndex = c.getColumnIndex("descr");

            c.moveToFirst();


            while (c != null) {
                textViewDesc.setText(c.getString(descIndex));
                textViewDescTitle.setText(c.getString(episodeIndex));
                textViewDescDate.setText(c.getString(dateIndex));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        WebView webView = (WebView) findViewById(R.id.webView9);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        webView.loadUrl("http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);
        Log.i("http requested", "http://liamure.net23.net/rsk/rsk2.html?ep=" + episodeRequested);


    }


    public void closeDesc(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayout);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r1Scroll);
        scrollview.scrollTo(0, currentScroll);

        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);


    }


    public void closeDescR2(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayoutR2);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodesR2);
       // episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r2Scroll);
        scrollview.scrollTo(0, currentScroll);




        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);

    }

    public void closeDescR3(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayoutR3);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodesR3);
        // episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r3Scroll);
        scrollview.scrollTo(0, currentScroll);




        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);

    }

    public void closeDescR4(View view) {

        DescLayout = (RelativeLayout) findViewById(R.id.relDescriptionLayoutR4);
        episodeGrid = (GridLayout) findViewById(R.id.gridEpisodesR4);
        // episodeGrid = (GridLayout) findViewById(R.id.gridEpisodes);

        scrollview = (ScrollView)findViewById(R.id.r4Scroll);
        scrollview.scrollTo(0, currentScroll);




        DescLayout.setVisibility(View.INVISIBLE);
        //cusView.setVisibility(View.VISIBLE);
        episodeGrid.setVisibility(View.VISIBLE);

    }

    private class DownloadTask extends AsyncTask<String, Integer, String> {

        private Context context;
        private PowerManager.WakeLock mWakeLock;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... sUrl) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(sUrl[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                // expect HTTP 200 OK, so we don't mistakenly save error report
                // instead of the file
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode()
                            + " " + connection.getResponseMessage();
                }

                // this will be useful to display download percentage
                // might be -1: server did not report the length
                int fileLength = connection.getContentLength();

                // download the file
                input = connection.getInputStream();
                output = new FileOutputStream("/sdcard/music/"+ downloadName +".MP3");

                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    // allow canceling with back button
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;
                    // publishing the progress....
                    if (fileLength > 0) // only if total length is known
                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
            } catch (Exception e) {
                return e.toString();
            } finally {
                try {
                    if (output != null)
                        output.close();
                    if (input != null)
                        input.close();
                } catch (IOException ignored) {
                }

                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // take CPU lock to prevent CPU from going off if the user
            // presses the power button during download
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                    getClass().getName());
            mWakeLock.acquire();
            mProgressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            // if we get here, length is known, now set indeterminate to false
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgress(progress[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            mWakeLock.release();
            mProgressDialog.dismiss();
            if (result != null)
                Toast.makeText(context,"Download error: "+result, Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"File downloaded", Toast.LENGTH_SHORT).show();
        }

    }

    public void buttonClicked(View view){
        final DownloadTask downloadTask = new DownloadTask(RadioActivity.this);
        downloadName =  view.getTag().toString();


        Toast.makeText(getApplicationContext(), "This app is free and features NO ads, please donate to keep it this way!", Toast.LENGTH_LONG).show();




        File file = new File("/sdcard/music/"+downloadName+".MP3");
        if(file.exists()){
            System.out.println("Play Content here");

            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            File file1 = new File("/sdcard/music/"+downloadName+".MP3");

            intent.setDataAndType(Uri.fromFile(file1), "audio/*");
            startActivity(intent);

        }else{

            System.out.println("DOES NOT EXIST");
            System.out.println("http://files.liamure.xyz/" + view.getTag().toString());
            downloadTask.execute("http://files.liamure.xyz/" + view.getTag().toString() + ".mp3");
            Button pressed = (Button) view;

            pressed.setText("Play");
            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    downloadTask.cancel(true);
                }
            });
        }

    }

    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        eventsDB = this.openOrCreateDatabase("App8908734", MODE_PRIVATE, null);


        createDB();


        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Radio1Fragment(),"Season 1");
        viewPagerAdapter.addFragments(new Radio2Fragment(),"Season 2");
        viewPagerAdapter.addFragments(new Radio3Fragment(),"Season 3");
        viewPagerAdapter.addFragments(new Radio4Fragment(),"Season 4");







        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        cusView =  (View)findViewById(R.id.view);


        if (shouldAskPermissions()) {
            askPermissions();
        }




        mProgressDialog = new ProgressDialog(RadioActivity.this);
        mProgressDialog.setMessage("Downloading your episode now!");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);

        File folder = new File(Environment.getExternalStorageDirectory() + "/Music");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }
        if (success) {
            Log.i("dir creation proc", "Directory Created");
        } else {
            Log.i("dir creation proc", "Directory Exists");
        }


        Toast.makeText(getApplicationContext(), "This app is free and features NO ads, please donate to keep it this way!", Toast.LENGTH_LONG).show();



    }

    public void deleteEpisode(View view){

        //This method allows a user to delete an individual episode



        File file = new File("/sdcard/music/"+ episodeRequested +".MP3");
        Log.i("DELETE", "/sdcard/music/"+ episodeRequested +".MP3");
        file.delete();



        Intent intent = getIntent();
        finish();
        startActivity(intent);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void OpenChangeLog(MenuItem item){
        Intent myIntent = new Intent(this, ChangeLog.class);
        startActivity(myIntent);
    }

    public void OpenPodcasts(MenuItem item){
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

    public void OpenRadio(MenuItem item){
        Intent myIntent = new Intent(this, RadioActivity.class);
        startActivity(myIntent);
    }

    public void openDonate(MenuItem item){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://liamure.xyz/donate.html"));
        startActivity(browserIntent);
    }

    public void openSettings(MenuItem item){
        Intent myIntent = new Intent(this, Settings.class);
        startActivity(myIntent);
    }






}
