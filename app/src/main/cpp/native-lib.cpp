#include <jni.h>
#include <string>
#include <iostream>
#include <vector>
#include "BackEndCpp.h"
#include <fstream>
using namespace std;

Login admin("Sreyas","lol");
vector <Login> users;
vector <LocationCpp> locs;


extern "C" JNIEXPORT jboolean JNICALL
Java_com_example_oopsappv6_MainActivity_signIn(
        JNIEnv* env,
        jobject,jstring uname,jstring upass){


    string checkuname=env->GetStringUTFChars(uname, nullptr);
    string checkupass=env->GetStringUTFChars(upass,nullptr);
    //string invalid="INVALID";

    LocationCpp temp(1,"MGROAD",12.9716,77.5946,"");
    locs.push_back(temp);

    if (admin.validate(checkuname,checkupass))
        return true;
    for (Login user:users) {
        if (user.validate(checkuname, checkupass)){
            return true;
        }
    }
    return false;
//    if (prac=="Sreyas")
//        return env->NewStringUTF(prac.c_str());
//    else
//        return env->NewStringUTF(invalid.c_str());
}



extern "C" JNIEXPORT void JNICALL
Java_com_example_oopsappv6_MainActivity_ReadLocation(JNIEnv* env,
        jobject){
    string s;
    ifstream myfile1("//data//data//com.example.oopsappv6//files//locationsfile.txt");
    string lati,longi;
    int count=0;
    while (getline(myfile1,s)){
        lati="";
        longi="";
        count=0;
        for(int i=0;i<s.length();i++){
            if (s[i]!=',' && count==0){
                lati+=s[i];
            }
            else if (s[i]!=',' && count==1){
                longi+=s[i];
            }
            else if (s[i]==','){
                count++;
            }
        }
        //cout<<lati<<endl<<longi;

    }

}




extern "C" JNIEXPORT void JNICALL
Java_com_example_oopsappv6_oopsMap_WriteLocation(JNIEnv* env,
        jobject,jint idCount,jdouble cpplat,jdouble cpplong,jstring js){
    string cpps=env->GetStringUTFChars(js, nullptr);
    ofstream myfile("//data//data//com.example.oopsappv6//files//locationsfile.txt",ios::app);
    myfile<<cpplat<<','<<cpplong<<endl;
//    LocationCpp temp(idCount,"",cpplat,cpplong,"");
    LocationCpp temp(idCount,"Bangalore",cpplat,cpplong,"NoAddress");
    locs.push_back(temp);
    
    myfile.close();
}
extern "C" JNIEXPORT jint JNICALL
Java_com_example_oopsappv6_DetailsLoc_LocLen(JNIEnv* env,
        jobject){
    return locs.size();
}
extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_oopsappv6_oopsMap_MapLat(JNIEnv* env,
    jobject,jint idcount){
    for (LocationCpp i:locs){
        if (i.getIdCpp()==idcount)
            return i.getLatitude();
    }
    return 0.0;
}
extern "C" JNIEXPORT jdouble JNICALL
Java_com_example_oopsappv6_oopsMap_MapLongi(JNIEnv* env,
        jobject,jint idcount){
    for (LocationCpp i:locs){
        if (i.getIdCpp()==idcount)
            return i.getLongitude();
    }
    return 0.0;
}
extern "C" JNIEXPORT jint JNICALL
Java_com_example_oopsappv6_oopsMap_LocCount(JNIEnv* env,
        jobject){
    return locs.size();
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_oopsappv6_DetailsLoc_WriteDet(JNIEnv* env,
        jobject,jint idCount,jstring j_title,jstring j_desc,jstring j_add){

    string cp_title=env->GetStringUTFChars(j_title, nullptr);
    string cp_desc=env->GetStringUTFChars(j_desc, nullptr);
    string cp_add=env->GetStringUTFChars(j_add, nullptr);

    for (LocationCpp i:locs){
        if (idCount==i.getIdCpp()){
            i.setAddress(cp_add);
            i.setDescription(cp_desc);
            i.setTitle(cp_title);

        }
    }

}
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_oopsappv6_DetailsLoc_SendTitle(JNIEnv* env,
        jobject,jint idCount){
    for (LocationCpp i:locs){
        if (i.getIdCpp()==idCount){
            string temp=i.getTitle();
            return env->NewStringUTF(temp.c_str());

        }
    }
    string no="EMPTY";
    return env->NewStringUTF(no.c_str());
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_oopsappv6_DetailsLoc_SendDesc(JNIEnv* env,
        jobject,jint idCount){

    for (LocationCpp i:locs){
        if (i.getIdCpp()==idCount){
            return env->NewStringUTF(i.getDescription().c_str());
        }
    }
    string no="EMPTY";
    return env->NewStringUTF(no.c_str());
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_oopsappv6_DetailsLoc_SendAdd(JNIEnv* env,
        jobject,jint idCount){

    for (LocationCpp i:locs){
        if (i.getIdCpp()==idCount){
            return env->NewStringUTF(i.getAddress().c_str());
        }
    }
    string no="EMPTY";
    return env->NewStringUTF(no.c_str());
}
extern "C" JNIEXPORT void JNICALL
Java_com_example_oopsappv6_contactAct_SendAdd(JNIEnv* env,
        jobject,jstring j_email,jstring j_phone,jint j_rating,jstring j_feedback){
    string cp_email=env->GetStringUTFChars(j_email, nullptr);
    string cp_phone=env->GetStringUTFChars(j_phone, nullptr);
    string cp_feedback=env->GetStringUTFChars(j_feedback, nullptr);


}
