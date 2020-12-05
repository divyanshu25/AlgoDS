//
// Created by Divyanshu Goyal on 8/18/20.
//


#include <iostream>       // std::cout
#include <string>         // std::string

int main ()
{
    std::string str ("abc def ghi");
//    std::string str2 ("needle");

//    // different member versions of find in the same order as above:
//    std::size_t found = str.find(str2);
//    if (found!=std::string::npos)
//        std::cout << "first 'needle' found at: " << found << '\n';
//
//    found=str.find("needles are small",found+1,6);
//    if (found!=std::string::npos)
//        std::cout << "second 'needle' found at: " << found << '\n';
//
//    found=str.find("haystack");
//    if (found!=std::string::npos)
//        std::cout << "'haystack' also found at: " << found << '\n';

    std::size_t found=str.find(' ');
    if (found!=std::string::npos)
        std::cout << "Period found at: " << found << '\n';

    std::cout << str.substr(found+1, str.size()-found-1) <<  "|||||"<<std::endl;

//    // let's replace the first needle:
//    str.replace(str.find(str2),str2.length(),"preposition");
//    std::cout << str << '\n';

    return 0;
}