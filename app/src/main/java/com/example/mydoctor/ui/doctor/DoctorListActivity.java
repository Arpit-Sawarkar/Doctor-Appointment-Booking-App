package com.example.mydoctor.ui.doctor;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mydoctor.R;
import java.util.ArrayList;
import adapter.DoctorAdapter;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsetsController;
public class DoctorListActivity extends AppCompatActivity {
    private RecyclerView rvDoctors;
    private TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        rvDoctors = findViewById(R.id.rvDoctors);
        tvTitle = findViewById(R.id.tvTitle);
        String specialty = getIntent().getStringExtra("specialty");
        if (specialty == null || specialty.trim().isEmpty()) {
            specialty = "Doctor";
        }Window window = getWindow();
        window.setStatusBarColor(Color.WHITE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowInsetsController controller = window.getInsetsController();
            if (controller != null) {
                controller.setSystemBarsAppearance(
                        WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                        WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }String displaySpecialty = specialty;
        if (specialty.equalsIgnoreCase("Orthopedaic")) {
            displaySpecialty = "Orthopedic";
        }tvTitle.setText(displaySpecialty + " Doctors");
        ArrayList<Doctor> doctorList = loadDoctorsBySpecialty(specialty);
        rvDoctors.setLayoutManager(new LinearLayoutManager(this));
        rvDoctors.setHasFixedSize(true);
        rvDoctors.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view,
                                       RecyclerView parent, RecyclerView.State state) {
                outRect.bottom = 20;
            }
        });
        DoctorAdapter adapter = new DoctorAdapter(this, doctorList);
        rvDoctors.setAdapter(adapter);
    }private ArrayList<Doctor> loadDoctorsBySpecialty(String specialty) {
        ArrayList<Doctor> list = new ArrayList<>();
        if (specialty.equalsIgnoreCase("Dentist")) {
            list.add(new Doctor(
                    "Dr. Akshay M. Dhewale",
                    "Dentist",
                    "MDS",
                    "6+ Years",
                    " Sumukh Multispeciality Dental Clinic A1 Complex, opposite Sardar Washing Company, Dr. Keche Hospital Road, Rathi Nagar, Amravati, Maharashtra 444603.",
                    "₹250",
                    "Key Professional Insights\n" +
                            "Micro-Endodontic Precision: Dr. Dhewale focuses on microscope-enhanced root canal treatments to ensure higher success rates, particularly in complex cases where anatomy is atypical. \n\n Conservative Tissue Preservation: His clinical philosophy aligns with modern endodontic trends of preserving as much healthy dentin as possible to maintain the tooth's long-term fracture resistance. \n\n Instrument Retrieval Expertise: He has developed a niche skill set in the highly technical task of retrieving broken instruments from root canals, a common complication that often otherwise leads",
                    R.drawable.dr_denakshay,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Abhijeet Wankhade",
                    "Dentist",
                    "MDS",
                    "13 Years",
                    "Dr Abhijit Wankhade's Sixteen Candles Children's Dental Clinic .3rd Floor, Empire Heights, Opposite Dr Praful Kadu, Main Road, Rukhmini Nagar, Amravati-444606, Maharashtra",
                    "₹300 ",
                    "Key insights : \n" +
                            " Friendly doctor who makes kids comfortable during treatment Establishes a personal connection with children calm and cool with both kids and parents",
                    R.drawable.dr_denabhijeet,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Avinash Kamble",
                    "General Dentist",
                    "MDS",
                    "5 Years",
                    " C/O Avinash Dental Clinic,  Shop No 7-8,  Aakar Apartment, Shop Number 7,  Sundarlal Chowk, Camp, Amravati-444602, Maharashtra",
                    "₹500",
                    "Dr. Avinash Kamble is a Dentist in Amravati Camp, Amravati and has an experience of 7 years in this field. Dr. Avinash Kamble practices at Dr Avinash Dental Clinic in Amravati Camp, Amravati. He completed MDS - Prosthodontist And Crown Bridge from Government Dental College & Hospital, Mumbai in 2019.. ",
                    R.drawable.dr_denavinash,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Pooja tagade",
                    "Dentist",
                    "MDS",
                    "4+ Years",
                    "Govind Villa Apartment, Near Tapovan Gate, Tapovan Road, Tapovan, Amravati-444602, Maharashtra",
                    "₹300",
                    "Dr. Pooja Kamble is gentle, thorough, knowledgeable and skilled in dental procedures. The staff is friendly, professional, attentive and accommodating. * The treatment provided is painless and effective with good results. ",
                    R.drawable.dr_denpooja,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Metkar",
                    "Dentist",
                    "MDS",
                    "3+ Years",
                    "Jay Amba Apartment, Kathora Road, VMV Road, Amravati, Maharashtra 444604.",
                    "₹300",
                    "Patient Comfort: For those with dental anxiety, the clinic provides conscious sedation options to ensure a stress-free experience. Specialised Expertise: It is specifically accredited for Laser Dentistry and is noted for its expertise in complex root canal treatments and orthodontic alignment.\n Safety & Hygiene: Patients frequently highlight the use of sterilised equipment and modern, clean facilities as key factors in feeling safe during treatments. ",
                    R.drawable.dr_denmetkar,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Korade",
                    "Dentist",
                    "MDS",
                    "13+ Years",
                    " Dr. KORDE'S Braces & Implant Center (Dr. Swapnil Korde): VMV Road, near Gupta Cement Depo, Vilas Colony, Kathora Naka, Amravati, Maharashtra 444604",
                    "₹300",
                    "High Satisfaction: Dr. Swapnil Korde’s dental practice maintains a 4.9 to 5.0-star rating across multiple platforms, with reviews highlighting his professional \"dedication\" and \"knowledgeable\" approach.",
                    R.drawable.dr_denkorade,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Mayur Ingole",
                    "Dentist",
                    "BDS",
                    "3+ Years",
                    "Shivlata Dental Clinic Opposite GST Bhavan, Mahatma Phule Nagar, Navsaari, Amravati-444602, Maharashtra",
                    "₹300",
                    "Patient Comfort: For those with dental anxiety, the clinic provides conscious sedation options to ensure a stress-free experience. Specialised Expertise: It is specifically accredited for Laser Dentistry and is noted for its expertise in complex root canal treatments and orthodontic alignment.",
                    R.drawable.dr_denmayur,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Anuroop kale ",
                    "Dentist",
                    "MDS",
                    "2+ Years",
                    "Dr. Kale'S Dental Clinic Holywood Nagar, Near Aarogya Bharati Medical, Behind Om Lahari Complex, Kathora Naka, Amravati-444604, Maharashtra",
                    "₹250",
                    "Patient Comfort: For those with dental anxiety, the clinic provides conscious sedation options to ensure a stress-free experience. Specialised Expertise: It is specifically accredited for Laser Dentistry and is noted for its expertise in complex root canal treatments and orthodontic alignment. ",
                    R.drawable.dr_denkale,
                    "+91 9423608436"));
        }
        else if (specialty.equalsIgnoreCase("Eye Surgeon")) {
            list.add(new Doctor(
                    "Dr. Pravin Vyawhare",
                    "Ophthalmologis",
                    "MBBS and MS in Ophthalmology ",
                    "8+ Years",
                    " C/o Vyavhare Netralaya, Vmv Road, Rampuri Camp, Amravati-444601, Maharashtra",
                    "₹500",
                    "An experienced ophthalmologist Dr.Pravin Prabhakar Vyawahare practicing in Amravati with his own eye clinic, Active professional presence in healthcare and eye treatment. \n\n Availability : 24 hour.",
                    R.drawable.dr_eyepravin,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Himanshu Satish Deshmukh",
                    "Opthamologist",
                    "MBBS , DO, DNB , FMRFa",
                    "15+ Years",
                    "Khaperde Gardens, Near Irwin square, Netradan Road, Amravati, Maharashtra 444602, India.",
                    "Not Mentioned",
                    "Dr Himanshu Deshmukh has done his basic medical training from Government Medical College, Nagpur, followed by ophthalmic training and fellowship in Retina from Sankara Nethralaya in Chennai. Subsequently he has worked as a faculty in LV Prasad Eye hospital in Hyderabad.",
                    R.drawable.dr_eyehemanshu,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Priyanka Bhansali",
                    "Ophthalmologist",
                    "MBBS MS",
                    "9+ Years",
                    "Bhansali Eye,Rajapeth Flyover, Rajapeth, Amravati. Clinic, Rajapeth Flyover, Rajapeth, Amravati.",
                    "₹400",
                    "Dr. Priyanka Bhansali provides comprehensive ophthalmic care, including:\n" +
                            " Eye examinations & consultations\n" +
                            " Glaucoma diagnosis and management\n" +
                            " Contact lens prescriptions\n" +
                            " Squint evaluations\n" +
                            " Retina checks and other ocular tests\n" +
                            " General eye health treatments and surgical referrals (if needed).",
                    R.drawable.dr_eyeprinka,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Sachin K. Bagade",
                    "Opthamologist ",
                    "MBBS MS",
                    "13 Years",
                    "Shri Sai Netralaya Eye Hospital, Infront Of Bank Of Baroda Bank, Sai Nagar Square, Sai Nagar, Amravati-444607, Maharashtra.",
                    "₹400",
                    "Profession & Specialty: Ophthalmologist —\n" +
                            " a medical doctor specializing in eye care and vision health.\n" +
                            "\n" +
                            "Practice Details: Appears on medical directory websites where patients can view consultation options and book appointments online. \n" +
                            "\n" +
                            "Reputation & Insights: There aren’t widely published detailed professional bio pages (e.g., clinic website, official hospital profile) available online for Dr. Sachin Bagde, but his listing in a medical directory confirms he is recognized as an eye care specialist in his region.",
                    R.drawable.dr_eyesachin,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Navin D. Soni",
                    "Contract, Cornea, and Lasik refractive Surgery ",
                    "MS , DNM DOMS , FICO(UK)",
                    "2+ Years",
                    " Dr. Soni'S Netranjali Eye , Maharashtra Major State Highway 6, Rajapeth, Amravati, Maharashtra, Square Road, Rajapeth, Amravati-444605, Maharashtra",
                    "₹400",
                    "Many customers mentioned Dr. Navin Soni's professionalism and extensive knowledge, highlighting his ability to explain procedures clearly and make patients feel comfortable.\n" +
                            "\n" +
                            "Several reviews praised the friendly and helpful nature of the clinic's staff, creating a welcoming environment for patients.",
                    R.drawable.dr_eyenavin,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Ankush Gondchawar",
                    "Ophthalmologist",
                    "MBBS, MS",
                    "6+ Years",
                    "Infinity Superspeciality Eye Hospital, Pansare Lane, Panchavati Square, Amravati,",
                    "₹300",
                    "Specialization: He is a dedicated Vitreoretina consultant and surgeon, focusing on complex retina surgeries, Retinopathy of Prematurity (ROP) screening and treatment, and advanced eye care. \n\n Top-Tier Training: He completed his DNB from the prestigious Sankara Nethralaya, Chennai, and specialized in Vitreoretina through a fellowship at Sankara Eye Hospital, Shimoga.",
                    R.drawable.dr_eyeankush,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Monika Lunge",
                    "Ophthalmologist & Eye Surgeon",
                    "MBBS DNB (Ophthalmology)",
                    "10 Years",
                    "Lunge Hospital Multispeciality & Eye Care, VMV Road, Rathi Nagar, Amravati.",
                    "₹500 (Approx)",
                    " Core Services:\n" +
                            " Comprehensive eye check-ups\n" +
                            " Diagnosis & treatment of common eye  diseases\n" +
                            " Squint evaluation\n" +
                            " Visual field testing\n" +
                            " Reputation: Known for patient-focused care and updated clinical approach",
                    R.drawable.dr_eyemonika,
                    "+91 9423608436"));
            list.add(new Doctor(
                    "Dr. Anil Harwani",
                    "Ophthalmologist",
                    "MBBS, MS",
                    "20+ Years",
                    " Netra Jyot Superspeciality Eye Hospital, Rajkamal Chowk Road, Rajapeth, Amravati.",
                    "₹400 - 500",
                    " Services & Expertise\n" +
                            " Offers a range of eye care.services, including:\n" +
                            " Lasik & laser refractive procedures\n" +
                            " Cataract treatment & surgery\n" +
                            " Contact lens prescription\n" +
                            " Retina & glaucoma examinations\n" +
                            " Squint evaluation\n" +
                            " General eye health diagnosis and  management. ",
                    R.drawable.dr_eyeanil,
                    "+91 9423608436"));
        }else if (specialty.equalsIgnoreCase("ENT")) {
            list.add(new Doctor(
                    "Dr. Prajakta Dhole (Mowale)",
                    "ENT Specialist & Head - Neck Surgeon",
                            "Professional Associate at Dr. Rajendra Gode Medical College & Hospital, Amravati",
                    "2+ Years",
                    "MEHER ENT Care Hospital, Arankar Complex, Nawathe Square, Beside Hotel Manwar, Vidhya Vihar Colony, Amravati, Maharashtra 444605",
                    "₹250 (Approx)",
                    "Dr. Prajakta Dhole is an ENT and Head - Neck surgeon offering comprehensive medical and surgical care for ear, nose, and throat disorders, with a focus on patient-friendly treatmer'",
                    R.drawable.dr_entdhole,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Sujit Sureshrao Dangore",
                    "ENT (Otorhinolaryngology) Specialist",
                    "MBBS, MD/MS - ENT",
                    "20 Years",
                    "Primary Clinic: Dr. Dangore Hospital, New Sangani Nagar, In front of Sunil Provision, Inside Ravi Nagar, Amravati, Maharashtra 444605 \n" +
                            "Secondary Clinic: 47, Sharda Vihar, Ravinagar Road, Amravati, Maharashtra",
                    "₹300 (Approx.)",
                    "Dr. Sujit Dangore is an experienced ENT specialist known for advanced procedures such as Endoscopic DCR surgery and thyroid surgeries.",
                    R.drawable.dr_entsujit,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Shrikant Mahhale",
                    "ENT Head & Neck Surgeon",
                    "MBBS, MD/MS ENT",
                    "30+ Years",
                    "Rajapeth Clinic: Siddharth Complex, Opposite Rajapeth Police Station, Below Arvind Cooperative Bank, Rajapeth, Amravati - 444605 \n Rukhmini Nagar Clinic: Get Life Healthcare Pvt. Ltd., Rukhmini Nagar, Amravati",
                    "₹250-₹400 (Approx.)",
                    "Dr. Shrikant Mahalle is a senior ENT and Head - Neck surgeon with over 30 years of experience, known for advanced ENT surgeries and cancer care.",
                    R.drawable.dr_entshrikant,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Tejal Lakhekar (Sonar)",
                    "ENT Surgeon",
                    "MS ENT (Master of Surgery)",
                    "2+ Years",
                    "Inside Life Line Hospital Building, Behind HP Petrol Pump, Vijay Colony, Rukhmini Nagar, Amravati, Maharashtra 444606",
                    "₹300 (Approx.)",
                    "Dr. Tejal Lakhekar is an ENT surgeon specializing in the treatment of vertigo, hearing loss, and common ear, nose, and throat disorders.",
                    R.drawable.dr_enttejal,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Swapnil Kothalkar",
                    "Consultant Neurosurgeon",
                    "MBBS, DNB Neurosurgery",
                    "10 Years",
                    "Creative Heights Complex, Above Bandhan Bank, Shivaji Nagar, Amravati, Maharashtra",
                    "₹300 (Approx.)",
                    "Dr. Swapnil Kothalkar is a consultant neurosurgeon specializing in vascular, skull base, spine, and stroke-related neurosurgical procedures.",
                    R.drawable.dr_entswapnil,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Kshitij Patil",
                    "ENT & Rhinoplasty Specialist",
                    "Not mentioned (Trained internationally in Germany for Rhinoplasty)",
                    "22+ Years",
                    "Patil ENT & Rhinoplasty Speciality Hospital, SH 199, Sharda Nagar, Rajapeth Square, Amravati, Maharashtra - 444605 \n" +
                            "(Near Flyover, Opposite Bhartiya College)",
                    "₹600",
                    "Dr. Kshitij Patil is a senior ENT and Rhinoplasty specialist recognized for functional and cosmetic nose surgeries, including advanced scarless techniques.",
                    R.drawable.dr_entksitij,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Swapnil Sharma",
                    "ENT Specialist & Head - Neck Cancer Surgeon",
                    "Not mentioned",
                    "14 Years",
                    "Suvidha ENT, Head and Neck Cancer Centre, Creative Heights Complex, Above Bandhan Bank, Main Road, Gadge Nagar, Amravati, Maharashtra 444603",
                    "₹300-₹500 (Approx.)",
                    "Dr. Swapnil Sharma is a highly rated ENT and Head-Neck Cancer surgeon with extensive experience in advanced nasal, sinus, and thyroid procedures.",
                    R.drawable.dr_entsharma,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Girish Tapadiya",
                    "ENT Surgeon / Specialist",
                    "MBBS, MS ENT",
                    "Not specifically listed (Well-established regional reputation)",
                    "Akansha Heart & ENT Clinic, Sai Plaza, Dufferin Road, Near Shrikrishna Peth, Mote Compound, Amravati, Maharashtra 444601 \n" +
                            "(Landmark: Near flyover and Shrikrishna Peth area)",
                    "₹300",
                    "Dr. Girish Tapadiya is an experienced ENT specialist providing advanced treatments and surgeries for ear, nose, and throat conditions for patients of all ages.",
                    R.drawable.dr_enttapdiya,
                    "+91 9423597515"));
        }else if (specialty.equalsIgnoreCase("Cardiologist")) {
            list.add(new Doctor(
                    "Dr. Shailesh S. Jayade",
                    "Interventional Cardiologist",
                    "MBBS, DNB (Internal Medicine), DNB (Cardiology), FESC, FSCAI (USA)",
                    "20+ Years",
                    "Axon Hospital (Opp. Tehsil Office, Rajkamal Square) & Shri Sant Achyut Maharaj Heart Hospital, Amravati",
                    " ₹400 (approx.)",
                    " A distinguished specialist who has performed over 16,000 cardiac procedures, focusing on complex angioplasties and advanced interventional care.",
                    R.drawable.dr_carjayde,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Niraj Prakash Raghani",
                    "Interventional Cardiologist (Adult and Pediatric)",
                    "MBBS, MD (General Medicine), DM (Cardiology), FACC, FESC, FSCAI (USA) ",
                    "18 – 22 Years",
                    "Zenith Heart and Multi-speciality Hospital, Cotton Market Road, Walcut Compound, Amravati – 444601 ",
                    "₹300 – ₹500",
                    "A prominent director and specialist recognized for performing complex coronary interventions and advanced structural heart disease treatments.",
                    R.drawable.dr_carniraj,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Tushar P. Lanjewar",
                    "Cardiologist and Diabetologist",
                    "MBBS, MD (Internal Medicine)",
                    "10 Years Overall ",
                    "Samarth Super Speciality Heart Hospital, Rukhmini Nagar Main Road, near Bank of Maharashtra, Amravati - 444606",
                    "₹1,000  ",
                    "Founder of Samarth Super Speciality Heart Hospital, recognized for his ethical approach and expertise in managing complex cardiac and diabetic conditions.",
                    R.drawable.dr_cartushar,
                    "+91 7796584711"));
            list.add(new Doctor(
                    " Dr. Nilesh Chandak",
                    "Interventional Cardiologist",
                    "MD (Medicine), DM (Cardiology)",
                    "9+ Years",
                    "RIMS Hospital (Rainbow Institute of Medical Sciences), Badnera Road, Amravati",
                    "₹500 (approx.)",
                    " A dedicated specialist at RIMS Hospital known for his expertise in complex cardiac interventions and public heart-health education.",
                    R.drawable.dr_carnilesh,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Rahul Kadu",
                    "Interventional Cardiologist",
                    "MD (General Medicine), DM (Cardiology)",
                    "13 – 19 Years Overall",
                    "Pulse Medicare & Cardiac Centre, Maszit to Irwin Road, Khaparde Bagicha, Amravati",
                    "₹300 – ₹500 (approx.)",
                    "A widely recognized specialist in minimally invasive cardiac procedures and complex interventional cardiology at Pulse Medicare & Cardiac",
                    R.drawable.dr_carkadu,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Bhushan Sonawane (Patil)",
                    "Interventional and Pediatric Cardiologist",
                    " MD (Medicine), DM (Cardiology), Fellowship (Pediatric Cardiology)",
                    "Experienced Professional (Specializing in Adult & Pediatric care)",
                    "Shree Saibaba Hospital, Rajkamal Square, Ambapeth, Amravat",
                    "₹400 – ₹500",
                    "A highly-rated specialist known for comprehensive adult and pediatric heart care, including emergency angioplasty procedures",
                    R.drawable.dr_carbhushan,
                    "+91  7796584711"));
            list.add(new Doctor(
                    "Dr. Satish W. Dahake",
                    "Pulmonologist (Chest Specialist)",
                    "MBBS, MMBBS, MD (Chest Medicine), DTCD, PGDDM",
                    "14 – 17 Years",
                    "Durvankur Hospital, Beside Dr. Sonali Deshmukh Hospital, Rukhmini Nagar, Amravati",
                    "₹400 – ₹1,000",
                    "A highly skilled respiratory expert specializing in the diagnosis and treatment of asthma, tuberculosis, and complex lung disorders",
                    R.drawable.dr_carsathish,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Pavan Agrawal",
                    " Interventional Cardiologist",
                    "MBBS, DNB (Internal Medicine), DNB (Cardiology), FESC, FSCAI",
                    "15+ Years (Practicing since 2010)",
                    "Radiant Superspeciality Hospital, Sabnis Plot, near Kalyan Nagar Square, Rukhmini Nagar, Amravati - 444606",
                    "₹400",
                    "Executive Director and Cath Lab Director at Radiant Hospital, specializing in complex cardiac interventions, pacemakers, and stroke management.",
                    R.drawable.dr_carpavan,
                    "+91 7796584711"));
        } else if (specialty.equalsIgnoreCase("Dermatologist")) {
         list.add(new Doctor(
                    "Dr. Yogesh Zanwar",
                    "(Dermatologist & Sexologist)",
                    "MBBS",
                    "27 Years",
                    "Apple Skin and Hair Clinic, Rajapeth.",
                    "₹700",
                    "Renowned dermatologist and cosmologist practising in amravati, Maharashtra with over 27 years of experience in the field.",
                    R.drawable.dr_dermatozavar,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Sanjay Agrawal",
                    "(Dermatologist & Sexologist)",
                    "MBBS MD",
                    "33 years.",
                    "Dr. Sanjay Agarwal Clinic, Rajkamal Square.",
                    "₹400 – ₹1,000.",
                    "Highly experienced Dermatologist and Cosmologist based in amravati, Maharashtra. He is recognised as one of the most senior skin specialists in the region, with over 30 years of experience in the medical field.",
                    R.drawable.dr_dermatosanjay,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Pallavi Pawar (Kandalkar)",
                    "(Dermatologist & Sexologist)",
                    " BHMS, DNYS, PGDCC.",
                    "4+ Years",
                    " Shree Skin and Hair Clinic, Rukhmini Nagar.",
                    "₹700",
                    "Known for kind patient interaction and effective keloid/scar treatments.",
                    R.drawable.dermatopawar,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Shwetal Rath",
                    "Skin, Hair, Nail & Cosmetology, Dermatologist",
                    "MBBS MS (Skin)",
                    "5 Years",
                    "Dr. Shwetal's Skin & Hair Clinic, Arihant Hospital Building, Badnera Road, Nawathe, Amravati",
                    "₹300 (Approx)",
                    "Popular for advanced skin treatments like HydraFacials, laser hair removal, and personalized acne solutions.",
                    R.drawable.dr_dermatorathi,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Anshu Rathi Chandak",
                    "Dermatologist, Cosmetologist, and Hair Specialist",
                    " MBBS, MD (Dermatology, Venereology, and Leprosy)",
                    "10+ Years",
                    "  I Skin Hospital, Beside D-Mart, Sai Nagar, Badnera Road, Amravati / Skin Cure Clinic, Ambapeth, Amravati",
                    " ₹250 – ₹500",
                    " A highly regarded skin and hair expert known for her accurate diagnoses and effective treatments in medical dermatology and advanced laser cosmetology.",
                    R.drawable.dr_dermoanshu,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Pooja Vilhekar Sadafale",
                    "Dermatologist, Aesthetic Dermatologist, and Trichologist",
                    "  MBBS (Dr. Panjabrao Deshmukh Memorial Medical College, 2017), DVD/DDV (Rajawadi Hospital, Mumbai, 2023).",
                    "7 – 9 Years Overall",
                    "  SkinEva Skin & Hair Clinic, 2nd Floor, Square Line Complex, Infront of Govt. Polytechnic College, Gadge Nagar, Amravati - 444604",
                    "₹300 – ₹500 (approx.)",
                    "A board-certified specialist recognized for her advanced expertise in PRP therapy, laser treatments, and aesthetic dermatology at her state-of-the-art Gadge Nagar clinic.",
                    R.drawable.dr_dermopooja,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Nishtha Nandurkar (Sangole)",
                    "Aesthetic Dermatologist and Cosmetologist",
                    "  MBBS (Amravati), MD (Dermatology, Nagpur), Fellowships (Mumbai, Dubai), Trained (London)",
                    " 8+ Years Overall",
                    "  Derma Esthetics Skin Clinic, 19, Venus Plaza, Shegaon Naka, VMV Road, Amravati - 444604",
                    "₹400 – ₹600 (approx.)",
                    "Founder of Derma Esthetics Skin Clinic and an internationally trained expert specialized in advanced lasers, aesthetic medicine, and clinical dermatology",
                    R.drawable.dr_dermonashtha,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Naina Ajmera",
                    "Dermatologist, Cosmetologist, and Trichologist",
                    " MBBS (PDMMC Amravati), DDVL (JJ Hospital, Mumbai), MD (Dermatology, USAIM)",
                    " 18 – 19 Years Overall",
                    " Nawandhar Building, Rajkamal Square, Auto Galli No. 2, Ambapeth, Amravati - 444601.",
                    "₹400",
                    " A highly experienced specialist known for personalized care in hair loss (PRP), fungal infections, and aesthetic procedures like skin polishing and chemical peels.",
                    R.drawable.dr_dermonaina,
                    "+91 7767832172"));
        } else if (specialty.equalsIgnoreCase("Gynaecologist")) {
            list.add(new Doctor(
                    "Dr. Monali Dhole",
                    "Gynecology and Fertility",
                    "MBBS, DGO",
                    "24 Years",
                    "Dhole Hospital, Rukhmini Nagar, Main Road, Amravati Maharashtra 444601",
                    "₹200",
                    "Dr. Monali Dhole is a well-known Gynecology and Fertility specialist with 24 years of experience. She is recognized for her compassionate care, ethical practice, and advanced treatment approach",
                    R.drawable.dr_gynodhole,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Usha Deshmukh",
                    "Gynecologist, Obstetrician",
                    "MBBS, DGO",
                    "41 Years Overall",
                    "Vatsalya Hospital, Rukhmini Nagar, Amravati City",
                    "₹300",
                    "A council-verified specialist practicing since 1984 with extensive experience in both public and private women's healthcare.",
                    R.drawable.dr_gynodeshmukh,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Shubhangi Mundhada",
                    "Gynecologist, Obstetrician",
                    "MBBS, MD (Obstetrics & Gynaecology), FICOG",
                    "39 Years Overall",
                    "Geetai Nursing Home, S.T. Stand Road, Opp Oosmaniya Masjid, Amravati",
                    "₹300",
                    "An accomplished FICOG fellow and specialist with nearly four decades of experience practicing at Geetai Nursing Home.",
                    R.drawable.dr_gynoshubhangi,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Rashmi Nagalkar",
                    "Gynecologist, Obstetrician",
                    "MBBS, DGO",
                    "18 Years Overall",
                    "Dr. Nagalkar Nursing Home, Shankar Nagar Road, Laxmi Narayan Nagar, Rajapeth, Amravati",
                    "₹500",
                    "An experienced specialist providing comprehensive women's healthcare at Dr. Nagalkar Nursing Home in Rajapeth, Amravati.",
                    R.drawable.dr_gynorashmi,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Umesh Sawarkar",
                    "Gynecologist, Obstetrician",
                    "MBBS, MS Obstetrics & Gynaecology",
                    "17 Years",
                    "Sawarkar Hospital, Congress Nagar Road, Shyam Nagar, Amravati",
                    "₹300 (Approx)",
                    "Dr. Umesh Sawarkar is an experienced gynecologist offering advanced obstetric and infertility care in Amravati.",
                    R.drawable.dr_gynoumesh,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Pranita Chandak",
                    "Gynecologist, Obstetrician, and Laparoscopic Surgeon",
                    "MS (Obstetrics & Gynecology), MBBS",
                    "4 Years (MS completed in 2022)",
                    "Dr. Ganesh Boob Smruti Hospital, Rathi Nagar, Amravati",
                    "₹500",
                    "A highly-rated specialist providing modern obstetric care and advanced laparoscopic surgery in the Amravati region.",
                    R.drawable.dr_gynochandak,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Pallavi Shete",
                    "Gynaecologist & Obstetrician",
                    "MD, DNB, MNAMS (GMC), Nagpur Government Medical College",
                    "31 Year",
                    "61, Krishnaarpan Colony, Behind Dashara Ground, Rajapeth, Amravati 444605, Maharashtra",
                    "₹300",
                    "A highly-rated specialist providing modern obstetric care and advanced laparoscopic surgery in the Amravati region.",
                    R.drawable.dr_gynopallavi,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Sakshi Heda",
                    "Obstetrician & Gynecologist",
                    "MD, DNB, MNAMS (GMC), Nagpur Government Medical College",
                    "10+ Years (Practicing Gynecology, Laparoscopy & Fertility Care) \n" +
                            "Fellowship in Endometriosis & Ultrasound (UK)",
                    "Elara Healthcare: Centre for Women's Health (Heda Hospital), Kazi Compound, Bus Stand Road, Maltekdi, Amravati, Maharashtra 444602",
                    "Not mentioned (Appointments via clinic or phone)",
                    "Dr. Sakshi Heda is a highly rated gynecologist specializing in high-risk pregnancies, infertility, and advanced laparoscopic care. She is known for patient-centric treatment and modern women's healthcare solutions.",
                    R.drawable.dr_gynoheda,
                    "+91 9423597515"));
            list.add(new Doctor(
                    "Dr. Ayush Ajaykumar Heda",
                    "Gynecologic Oncologist & Minimally Invasive Surgeon",
                    "MBBS KEM Hospital & Seth GS Medical College, Mumbai \n" +
                            "MD - Obstetrics & Gynaecology, AIIMS New Delhi \n" +
                            "M.Ch Gynecologic Oncology, AIIMS Rishikesh \n" +
                            "Additional: DNB, MNAMS, FMAS, MBA",
                    "10+ Years (Including specialized oncology training & fellowships)",
                    "Elara Healthcare: Centre for Women's Health (Heda Hospital), \n" +
                            "Kazi Compound, Bus Stand Road, Maltekdi, Amravati, Maharashtra - 444602",
                    "₹500",
                    "Dr. Ayush Heda is a highly skilled Gynecologic Oncologist specializing in advanced cancer care and minimally invasive surgeries. He is a Gold Medalist from AIIMS and known fo patient-focused treatment",
                    R.drawable.dr_gynoayush,
                    "+91 9423597515"));
        } else if (specialty.equalsIgnoreCase("Orthopedaic")) {
            list.add(new Doctor(
                    "Dr. Gaurav Bhutada",
                    " Orthopedic Surgeon, Endoscopic Spine Surgeon, and Pain Specialist",
                    "MBBS, MS (Orthopaedics)",
                    "10 Years Overall",
                    "Precision Ortho Clinic, Behind Adwani Hospital, Amba Peth, Amravati - 444601",
                    "₹300",
                    "A highly skilled specialist in endoscopic spine surgery and trauma care, recognized for his patient-centric and diagnostic excellence.",
                    R.drawable.dr_orthogaurav,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Ankush Nawale",
                    "Orthopaedic Surgeon and Spine Specialist",
                    "MBBS, MS (Orthopaedics)",
                    "13+ Years in Healthcare",
                    "Dr. Ankush Nawale Orthopaedic Spine and Accident Hospital, Sai Nagar, near Hyundai Showroom, Badnera Road, Amravati 444601.",
                    "₹300 – ₹500 (approx.)",
                    "A prominent specialist recognized for his expertise in endoscopic spine surgery and trauma care, offering affordable and patient-centric medical services.",
                    R.drawable.dr_orthoankush,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Nitin Jaiswal",
                    "Consultant Spine and Orthopaedic Surgeon",
                    "MBBS, DNB (Orthopaedics), Fellowship in Spine Surgery",
                    "12+ Years Overall",
                    "Shreshth Spine Care, Tote Hospital, Rathi Nagar, Amravati / RIMS Hospital, Badnera Road, Amravati 444601",
                    " ₹300 – ₹500 (approx.)",
                    "Director of Shreshth Spine Care and award-winning author specialized in minimally invasive spine surgery and deformity correction",
                    R.drawable.dr_orthonitin,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Dhananjay D. Deshmukh",
                    "Orthopaedic, Arthroscopy, and Robotic Joint Replacement Surgeon",
                    "MBBS, D. Ortho, MCh (Ortho), MRCS (I), FISS, FJRS",
                    "Experienced Specialist (Over 450 Total Knee Replacements performed)",
                    "Sunshine Superspeciality Hospital, Plot No. 41, Farshi Stop, near SBI Bank, Dastur Nagar, Amravati 444601.",
                    " ₹300 (Initial Consultation)",
                    "Medical Director of Sunshine Hospital, renowned for 100% successful complex surgeries in sports injuries and advanced robotic joint replacements.",
                    R.drawable.dr_orthodeshmukh,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Nilesh Janardan Keche",
                    "Robotic Joint Replacement, Spine, and Arthroscopy Surgeon",
                    "MBBS, MS (Orthopaedics - Mumbai), DNB (Orthopaedics - New Delhi)",
                    "12+ Years",
                    "anarpan Hospital, Computer Circle Road, Rathi Nagar, Gadge Nagar, Amravati - 444603",
                    "₹300 – ₹500 (approx.)",
                    " A pioneer in robotic joint replacement in Amravati, providing advanced spine and orthopaedic care with international training from Singapore and South Korea",
                    R.drawable.dr_orthonilesh,
                    "+91 7796584711"));
            list.add(new Doctor(
                    " Dr. Govind Lahoti",
                    "Orthopaedic and Trauma Surgeon",
                    "MBBS, MS (Orthopaedics)",
                    "30+ Years Overall",
                    " Navjivan Hospital, Camp Road, Near Govt. Girls High School, Maltekdi, Amravati - 444601",
                    "₹500 – ₹1,000",
                    "A highly respected veteran surgeon leading the NABH-accredited Navjivan Hospital, specializing in joint replacements and complex trauma care.",
                    R.drawable.dr_orthogovind,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Swapnil Gadge",
                    "Orthopedic and Joint Replacement Surgeon",
                    "MBBS, MS, (Orthopaedics), Fellowship (NHS, Scotland, UK)",
                    "14 – 21 Years Overall",
                    "Gadge Hospital, Near Coffee House Square, West High Court Road, Dharampeth, Nagpur - 440010",
                    "₹500",
                    "An internationally trained specialist in advanced joint replacement and complex trauma, serving patients across the Amravati and Nagpur regions.",
                    R.drawable.dr_orthoswapnil,
                    "+91 7796584711"));
            list.add(new Doctor(
                    "Dr. Bhushan Gulabrao Sagane",
                    "Orthopaedic & Joint Replacement Surgeon",
                    "MBBS (JNMC, Sawangi, 2003), D-Ortho (RMKC, Nashik, 2008), ATLS Certified",
                    "22+ Years Overall (Practicing as a consultant since 2008)",
                    "Radiant Superspeciality Hospital, Kalyan Nagar Chowk / Get Life Hospital, Rukhmini Nagar, Amravati 444601.",
                    "₹500",
                    " A veteran surgeon who has performed over 3,000 procedures, specializing in trauma, joint replacements (Knee/Hip), and advanced arthroscopic surgeries.",
                    R.drawable.dr_orthobhushan,
                    "+91 7796584711"));
        } else if (specialty.equalsIgnoreCase("General Physician")) {
            list.add(new Doctor(
                    "Dr. Shrikant Deshmukh",
                    "General Physician",
                    "MBBS",
                    " 45–46 years.",
                    "Manas Clinic, Rukhmini Nagar, Amravati 444601.",
                    "₹400",
                    "A veteran physician specializing in general medicine and de-addiction.",
                    R.drawable.dr_gendeshmukh,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Ajinkya Jamthe",
                    "General Physician",
                    "MBBS, MD (Medicine)",
                    " 11 years.",
                    "Jamthe Multispeciality Hospital, Congress Nagar Road, Rukhmini Nagar, Amravati",
                    "₹400 (Approx.",
                    "Known for handling critical medical cases and infectious diseases at one of Amravati's oldest hospitals.",
                    R.drawable.dr_genjamthe,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Manjushree Boob",
                    "General Physician",
                    "MBBS",
                    " 32 years.",
                    "Shubham Hi-Tech Hospital, Badnera Road, Rajapeth, Amravati.",
                    "₹300  (Approx.)",
                    " Highly experienced in general medicine; specialized in family healthcare and routine consultations.",
                    R.drawable.dr_genboob,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Devendra Agrawal",
                    "General Physician",
                    " MBBS, DNB",
                    " 23 years.",
                    "Sarvodaya Hospital, Paratwada Rd, Amravati.",
                    "₹150 at clinic / ₹200 online",
                    "Experienced GP specializing in internal medicine, common disease management, and preventive care.",
                    R.drawable.dr_genagrwal,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Bhavana Vaikunth Sontakke",
                    "General Physician",
                    " MBBS",
                    " 21 years.",
                    "Apex Hospital & Nursing Home, Amravati Camp.",
                    "₹300 at clinic",
                    "Trusted doctor with rich experience in internal medicine and comprehensive patient care.",
                    R.drawable.dr_genbhavna,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Ashok N. Rathi",
                    "General Physician",
                    " MBBS",
                    " 44 years.",
                    " Old Cotton Market, Amravati.",
                    "₹300 at clinic",
                    "Highly experienced physician with decades of practice in general medicine and routine care.",
                    R.drawable.dr_genrathi,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Shubham Vijay Deshmukh",
                    "General Physician",
                    " MBBS",
                    " years.",
                    "Dr Sharad Deshmukh Hospital & others, Warud, Amravati.",
                    "₹100",
                    " Young and approachable GP providing accessible and affordable primary care.",
                    R.drawable.dr_genshubham,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Swati Aggarwal",
                    "General Physician",
                    " MBBS + Fellowship in Diabetes & Advanced Certificate in Diabetes & Cardiovascular Diseases",
                    " 15+ years.",
                    " Amravati area 444601",
                    "Approx ₹500 per visit",
                    "Physician with additional training in diabetes and cardiovascular care, making her a good choice for patients with metabolic disorders or general health issues. \n Fellowship in Diabetes & Advanced Certificate in Diabetes & Cardiovascular Diseases",
                    R.drawable.dr_genswati,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Rachna Kucheria",
                    "General Physician",
                    "MD (Community Medicine) from AIIMS New Delhi + MD (Family Medicine) USC California",
                    " 10+ years.",
                    " Badnera Road, Nawathe square Amravati",
                    "Approx ₹1200 per consultation (clinic or online)",
                    "Highly experienced general physician with advanced qualifications in family medicine and community health. Ideal for comprehensive general medical care, chronic disease management and health screenings",
                    R.drawable.dr_genrachna,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Navneet Kaur",
                    "General Physician",
                    " MBBS (Govt Medical College, Amritsar) ",
                    " 23+ years.",
                    "Congress Nagar Rd, Shyam Nagar, Amravati 444601.",
                    "Approx ₹600 per visit",
                    "Experienced general physician serving a wide range of adult health issues.",
                    R.drawable.dr_gennavneet,
                    "+91 7767832172"));
        } else { list.add(new Doctor(
                    "Dr. Vinit Saboo (Vineet Saboo) ",
                    "Diabetologist and Endocrinologist  ",
                    " MBBS (KEM Hospital, Mumbai), PG Diploma in Diabetology (Seth GS Medical College, Mumbai), CDFM (Pune) ",
                    " 17+ years.",
                    "Saboo Diabetes, Thyroid and Dental Centre, Samarth School Road, Deorankar Nagar, Ravi Nagar, Amravati - 444605",
                    "300 - 400 ",
                    "Amravati's first specialized thyroid and hormone expert, renowned for his academic excellence at KEM Mumbai and his comprehensive management of complex metabolic disorders.",
                    R.drawable.dr_defaultvinit,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Ajay Daphale",
                    " General Physician and Consultant Physician",
                    " MBBS, MD (Medicine)",
                    " 17+ years.",
                    "Daphale Hospital, Opp. Atul Mangal Karyalaya, Rukhmini Nagar, Amravati - 444606",
                    " ₹300 – ₹500 (approx.)",
                    "A veteran \"pillar\" of Amravati’s medical community, known for his ethical practice and expertise in treating infectious diseases, hypertension, and critical care.",
                    R.drawable.dr_defaultajay,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr.  Vikram Rode ",
                    " General Physician and Critical Care Specialist",
                    "MBBS (PDMMC Amravati), MD (Internal Medicine), IDCCM (Critical Care), Certificate in 2D Echo",
                    "14+ Years Overall",
                    "Saboo ",
                    "200 - 300 ",
                    "An experienced physician and intensive care expert specializing in the management of infectious diseases, diabetes, and respiratory disorders.",
                    R.drawable.dr_defaultrode,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Vikram R. Wankhade",
                    "Neuropsychiatrist ",
                    "MBBS, DPM (Psychiatry)",
                    " 9 years.",
                    "Antarman Hospital & Mind Care Center, Rukhmini Nagar, Amravati - 444606",
                    "300",
                    "A dedicated mental health professional specializing in the treatment of anxiety, depression, and addiction through advanced neuropsychiatric care.",
                    R.drawable.dr_defaultvikram,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr.Vikram U. Deshmukh ",
                    "Urologist",
                    " MBBS, MS, MCh (Urology)",
                    " 20+ years.",
                    "Shree Urology Hospital, Walcut Compound, Near Vikram Road, Amravati - 444601",
                    "500",
                    "A senior urological surgeon with two decades of experience in treating kidney stones, prostate conditions, and male fertility issues.",
                    R.drawable.dr_defaultdeshmukh,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr.Pallavi Atul Choudhari",
                    "Homeopathic Physician, Clinical Cosmetologist, and Trichologist",
                    "BHMS (Amravati University, 2000), MD - Homeopathy (Navi Mumbai, 2007), PGDCC (Clinical Cosmetology), PG Diploma in Trichology",
                    "2 Month",
                    "Shri Swami Samarth Homeo Clinic, Guru Samarth Apartment, New Krushnarpan Colony, Shilangan Road, Rajapeth/Rajkamal Square, Amravati - 444601",
                    "200",
                    "A veteran practitioner specializing in holistic homeopathic care combined with advanced clinical cosmetology. She is highly regarded for treating chronic skin diseases, hair loss, and female-specific health concerns.",
                    R.drawable.dr_defaultpallavi,
                    "+91 7767832172"));
            list.add(new Doctor(
                    " Dr. Rupesh S. Makode ",
                    "Neurologist (Brain, Spine, Muscle & Nerve)",
                    "  MBBS, DNB (General Medicine - Kolkata), DNB (Neurology - Pune)",
                    " 15+ Years Overall.",
                    " Neurology Clinic, Zenith Heart and Multispeciality Hospital, Walcut Compound, Amravati - 444601",
                    "1,000",
                    " A specialist in neuro-critical care and chronic neurological disorders, practicing in Amravati since 2019. He is highly regarded for treating complex cases of stroke, epilepsy, Parkinson's, and peripheral neuropathy.",
                    R.drawable.dr_defaultrupesh,
                    "+91 7767832172"));
            list.add(new Doctor(
                    " Dr. Aniket Wadal",
                    "Consultant Physician (General Medicine)",
                    " MBBS, MD (General Medicine)",
                    " 8+ Years Overall (Assistant Professor at Dr. Rajendra Gode Medical College)",
                    " Wadal Clinic, Devi Heaven, B 204, Kathora Road, Vijay Colony, Amravati - 444604",
                    "500",
                    "A highly skilled physician specializing in cardiac emergencies and stroke cases, currently serving as an Assistant Professor in General Medicine while managing his private practice at Kathora Naka.",
                    R.drawable.dr_defaultaniket,
                    "+91 7767832172"));
            list.add(new Doctor(
                    "Dr. Nitin Kantilal Seth ",
                    "Pediatrician and Neonatologist",
                    " MBBS (GMC Nagpur, 1981), DCH (GMC Nagpur, 1985))",
                    " 40+ Years (Practicing since 1986)",
                    ": Mukta Children Hospital, Rallies Plot, Patvipura, Opposite Agrasen Bhavan, Rajkamal Square, Amravati - 444601",
                    "₹700 (Initial Consultation)",
                    " Founder of Mukta Children Hospital and pioneer of the region's first NICU, specializing in the care of extremely premature infants and low birth weight babies.",
                    R.drawable.dr_defaultnitin,
                    "+91 7767832172"));
        }
        return list;
    }
}
